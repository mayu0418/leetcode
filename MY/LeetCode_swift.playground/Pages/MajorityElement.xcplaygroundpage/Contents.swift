//: [Previous](@previous)

import Foundation

/**
 * Question Link: https://leetcode.com/problems/majority-element/
 * Primary idea: traverse the array and track the majority element accordingly
 *
 * Time Complexity: O(n), Space Complexity: O(1)
 * 给定数组，找出一个数出现次数超过⌊ n/2 ⌋
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

 You may assume that the array is non-empty and the majority element always exist in the array.
 */

class MajorityElement {
    func majorityElement(_ nums: [Int]) -> Int {
        var count = 0, candidate = 0
        
        for num in nums {
            if count == 0 {
                candidate = num
            }
            
            count += (candidate == num) ? 1 : -1
        }
        
        return candidate
    }
}
