//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)
/**
 * Question Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Primary idea: Two pointers -- left moves forward and right moves backward to meet the right two sum.
 *
 * Time Complexity: O(n), Space Complexity: O(n)
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 */

class TwoSumII {
    func twoSum(_ numbers: [Int], _ target: Int) -> [Int] {
        if numbers.count <= 1 {
            return [Int]()
        }
        
        var left = 0, right = numbers.count - 1
        
        while left < right {
            if numbers[left] + numbers[right] < target {
                left += 1
            } else if numbers[left] + numbers[right] > target {
                right -= 1
            } else {
                return [left + 1, right + 1]
            }
        }
        
        return [Int]()
    }
}
