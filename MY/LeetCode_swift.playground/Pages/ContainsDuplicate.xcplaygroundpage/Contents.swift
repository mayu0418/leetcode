//: [Previous](@previous)

import Foundation

/**
 * Question Link: https://leetcode.com/problems/contains-duplicate/
 * Primary idea: traverse the array and use a set to check duplicates
 *
 * Time Complexity: O(n), Space Complexity: O(n)
 *  给定数组 判断是否包含重复数字
 */

class ContainsDuplicate {
    func containsDuplicate(nums: [Int]) -> Bool {
        return nums.count > Set(nums).count
    }
}
