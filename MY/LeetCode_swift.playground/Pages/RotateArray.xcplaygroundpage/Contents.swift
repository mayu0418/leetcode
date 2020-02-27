//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)
/**
 * Question Link: https://leetcode.com/problems/rotate-array/
 * Primary idea: reverse the whole array, then reverse parts of it seperately
 *
 * Note: Argument of a function in Swift is let by default, so change it to var if you need to alter the value
 *
 * Time Complexity: O(n), Space Complexity: O(1)
 *Given an array, rotate the array to the right by k steps, where k is non-negative.

 Example 1:

 Input: [1,2,3,4,5,6,7] and k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]
 Example 2:

 Input: [-1,-100,3,99] and k = 2
 Output: [3,99,-1,-100]
 Explanation:
 rotate 1 steps to the right: [99,-1,-100,3]
 rotate 2 steps to the right: [3,99,-1,-100]
 */

class RotateArray {
    func rotate(_ nums: inout [Int], _ k: Int) {
        guard nums.count > 0 && k > 0 else {
            return
        }
        let k = k % nums.count
        guard k != 0 else {
            return
        }
        _reverse(&nums, 0, nums.count - 1)
        _reverse(&nums, 0, k - 1)
        _reverse(&nums, k, nums.count - 1)
    }
    
    private func _reverse(_ nums: inout [Int], _ startIdx: Int, _ endIdx: Int) {
        // edge case
        if startIdx < 0 || endIdx > nums.count || startIdx >= endIdx {
            return
        }
        
        var startIdx = startIdx
        var endIdx = endIdx
        
        while startIdx < endIdx {
            _swap(&nums, startIdx, endIdx)
            startIdx += 1
            endIdx -= 1
        }
    }
    
    private func _swap<T>(_ nums: inout Array<T>, _ p: Int, _ q: Int) {
        (nums[p], nums[q]) = (nums[q], nums[p])
    }
}
