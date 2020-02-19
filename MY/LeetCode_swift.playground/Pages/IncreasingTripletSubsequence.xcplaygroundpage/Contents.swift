//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)
/**
 * Question Link: https://leetcode.com/problems/increasing-triplet-subsequence/
 * Primary idea: Two pointers. One is to store the smallest value,
 *               the other is to store the second smallest value.
 *               Return true once find a value greater than both.
 * Time Complexity: O(n), Space Complexity: O(1)
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * Formally the function should:

 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 */

class IncreasingTripletSubsequence {
    func increasingTriplet(_ nums: [Int]) -> Bool {
        var smallest = Int.max, smaller = Int.max
        
        for num in nums {
            if smallest >= num {
                smallest = num
            } else if smaller >= num {
                smaller = num
            } else {
                return true
            }
        }
        
        return false
    }
}
