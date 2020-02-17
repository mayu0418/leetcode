//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)
/**
 * Question Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * Primary idea: keep a index, compare between the element at that index, the element at index - 1,
 *               and the element moving forward
 * Time Complexity: O(n), Space Complexity: O(1)
 *给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 */

class RemoveDuplicatesFromSortedArrayII {
    func removeDuplicates(inout nums: [Int]) -> Int {
        guard nums.count > 2 else {
            return nums.count
        }
        
        var index = 1
        
        for i in 2..< nums.count {
            if nums[index] != nums[index - 1] || nums[index] != nums[i] {
                index += 1
                nums[index] = nums[i]
            }
        }
        
        return index + 1
    }
}
