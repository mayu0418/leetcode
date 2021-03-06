//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)
/**
 * Question Link: https://leetcode.com/problems/3sum/
 * Primary idea: Sort the array, and traverse it, increment left or decrease right
 *               predicated on their sum is greater or not than the target
 * Time Complexity: O(n^2), Space Complexity: O(nC3)
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */

class ThreeSum {
    func threeSum(_ nums: [Int]) -> [[Int]] {
        var res = [[Int]]()
        
        guard nums.count >= 3 else {
            return res
        }
        
        let nums = nums.sorted()
        
        for i in 0 ..< nums.count - 2 {
            if i > 0 && nums[i] == nums[i - 1] {
                continue
            }
            
            let firstNum = nums[i], remainingSum = -firstNum
            var m = i + 1, n = nums.count - 1
            
            while m < n {
                if nums[m] + nums[n] == remainingSum {
                    res.append([firstNum, nums[m], nums[n]])
                    
                    repeat {
                        m += 1
                    } while nums[m] == nums[m - 1] && m < n
                    
                    repeat {
                        n -= 1
                    } while nums[n] == nums[n + 1] && m < n
                } else if nums[m] + nums[n] < remainingSum {
                    m += 1
                } else {
                    n -= 1
                }
            }
        }
        
        return res
    }
}
