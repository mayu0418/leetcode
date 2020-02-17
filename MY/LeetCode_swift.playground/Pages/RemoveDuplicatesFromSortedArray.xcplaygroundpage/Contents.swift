//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)
/**
 * Question Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Primary idea: keep a index, compare the element at that index with the element moving forward
 * Time Complexity: O(n), Space Complexity: O(1)
 *  给有序数组，删除重复元素，返回新长度
 */

class RemoveDuplicatesFromSortedArray {
    func removeDuplicates(inout nums: [Int]) -> Int {
        guard nums.count > 0 else {
            return 0
        }
        
        var index = 0
        
        for num in nums where num != nums[index] {
            index += 1
            nums[index] = num
        }
        
        return index + 1
    }
}
