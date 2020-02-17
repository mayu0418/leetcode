//: [Previous](@previous)

import Foundation

/**
 * Question Link: https://leetcode.com/problems/first-missing-positive/
 * Primary idea: Use a set to hold number in the array and iterate through 1...nums.count to find the missing one
 * Time Complexity: O(n), Space Complexity: O(n)
 *
 *Given an unsorted integer array, find the smallest missing positive integer.
给一个无须数组 找出最小的正整数
 Example 1:

 Input: [1,2,0]
 Output: 3
 Example 2:

 Input: [3,4,-1,1]
 Output: 2
 Example 3:

 Input: [7,8,9,11,12]
 Output: 1
 */

class FirstMissingPositive {
    func firstMissingPositive(_ nums: [Int]) -> Int {
        let set = Set(nums)
        
        for i in 0 ..< nums.count {
            if !set.contains(i + 1) {
                return i + 1
            }
        }
        
        return nums.count + 1
    }
}
