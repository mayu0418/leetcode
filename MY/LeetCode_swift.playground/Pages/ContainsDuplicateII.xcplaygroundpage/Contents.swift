//: [Previous](@previous)

import Foundation

/**
 * Question Link: https://leetcode.com/problems/contains-duplicate-ii/
 * Primary idea: use a dictionary to check duplicates, then judge if their distance is less than k
 *
 * Time Complexity: O(n), Space Complexity: O(n)
 *
 *Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。

 Example 1:

 Input: nums = [1,2,3,1], k = 3
 Output: true
 Example 2:

 Input: nums = [1,0,1,1], k = 1
 Output: true
 Example 3:

 Input: nums = [1,2,3,1,2,3], k = 2
 Output: false
 *
 *
 */

class ContainsDuplicateII {
    func containsNearbyDuplicate(_ nums: [Int], _ k: Int) -> Bool {
        guard nums.count > 1 else {
            return false
        }
        
        var numToLastIndex = [Int : Int]()
         
        for (i, num) in nums.enumerated() {
            if let lastIndex = numToLastIndex[num], i - lastIndex <= k {
                return true
            } else {
                numToLastIndex[num] = i
            }
        }
        
        return false
    }
}
