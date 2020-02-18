//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)
/**
 * Question Link: https://leetcode.com/problems/remove-element/
 * Primary idea: keep a index, compare the element at that index with val while moving forward
 * Time Complexity: O(n), Space Complexity: O(1)
 *给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 */

class RemoveElement {
    func removeElement( nums: inout [Int], _ val: Int) -> Int {
        nums = nums.filter { (num) in num != val }
        return nums.count
    }
}
