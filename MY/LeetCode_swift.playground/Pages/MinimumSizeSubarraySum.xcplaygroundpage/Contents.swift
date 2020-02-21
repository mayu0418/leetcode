//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)
/**
 * Question Link: https://leetcode.com/problems/minimum-size-subarray-sum/
 * Primary idea: Two Pointers, anchor the former and move forward the latter one to ensure the sum of subarray just covers the target
 * Note: There could be no valid subarray which sum >= target
 * Time Complexity: O(n), Space Complexity: O(1)
 *Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 Example:

 Input: s = 7, nums = [2,3,1,2,4,3]
 Output: 2
 Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 Follow up:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 */

 class MinimumSizeSubarraySum {
    func minSubArrayLen(_ s: Int, _ nums: [Int]) -> Int {
        var miniSize = Int.max, start = 0, currentSum = 0
        
        for (i, num) in nums.enumerated() {
            currentSum += num
            
            while currentSum >= s, start <= i {
                miniSize = min(miniSize, i - start + 1)
                
                currentSum -= nums[start]
                start += 1
            }
        }
        
        return miniSize == Int.max ? 0 : miniSize
    }
}
