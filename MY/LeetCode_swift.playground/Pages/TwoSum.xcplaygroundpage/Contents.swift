//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)
/**
 * Question Link: https://leetcode.com/problems/two-sum/
 * Primary idea: Traverse the array and store target - nums[i] in a dict
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * Time Complexity: O(n), Space Complexity: O(n)
 */

class TwoSum {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var dict = [Int : Int]()
  
        for (i, num) in nums.enumerated() {
            if let lastIndex = dict[target - num] {
                return [lastIndex, i]
            }
    
            dict[num] = i
        }
  
        fatalError("No valid outputs")
    }
}
