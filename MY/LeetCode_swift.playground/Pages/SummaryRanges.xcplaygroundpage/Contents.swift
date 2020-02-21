//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)

/**
 * Question Link: https://leetcode.com/problems/summary-ranges/
 * Primary idea: Traverse the array and build string when num[i] != num[i - 1] + 1,
 *               note to handle the edge case when it goes to the end of the array
 *
 * Time Complexity: O(n), Space Complexity: O(n)
 *
 *Given a sorted integer array without duplicates, return the summary of its ranges.

 Example 1:

 Input:  [0,1,2,4,5,7]
 Output: ["0->2","4->5","7"]
 Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 Example 2:

 Input:  [0,2,3,4,6,8,9]
 Output: ["0","2->4","6","8->9"]
 Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */

class SummaryRanges {
    func summaryRanges(nums: [Int]) -> [String] {
        var res = [String]()
        var str = ""
        var start = 0
        
        guard nums.count > 0 else {
            return res
        }
  
        for i in 0 ... nums.count {
            if i == nums.count || (i > 0 && nums[i] != nums[i - 1] + 1) {
                str = "\(nums[start])"
                if i - 1 != start {
                    str += "->\(nums[i - 1])"
                }
                res.append(str)
                start = i
            }
        }
        return res
    }
}
