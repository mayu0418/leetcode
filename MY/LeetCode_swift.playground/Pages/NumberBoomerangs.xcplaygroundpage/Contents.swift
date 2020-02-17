//: [Previous](@previous)

import Foundation

/**
 * Question Link: https://leetcode.com/problems/number-of-boomerangs/
 * Primary idea: traverse the array and compare distance one by one
 *
 * Time Complexity: O(n^2), Space Complexity: O(n)
 *给定若干(x,y)坐标数组，求满足（i,j,k）i坐标到j距离等于i到k的距离的个数
 *Input:
 [[0,0],[1,0],[2,0]]

 Output:
 2

 Explanation:
 The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */

 class NumberBoomerangs {
    func numberOfBoomerangs(_ points: [[Int]]) -> Int {
        var num = 0
  
        for (i, point) in points.enumerated() {
            var dict = [Int: Int]()
            for (j, anotherpoint) in points.enumerated() {
                if i == j {
                    continue
                }
      
                let distance = (anotherpoint[0] - point[0]) * (anotherpoint[0] - point[0]) + (anotherpoint[1] - point[1]) * (anotherpoint[1] - point[1])
      
                if let sameDistancePoints = dict[distance] {
                    dict[distance] = sameDistancePoints + 1
                } else {
                    dict[distance] = 1
                }
            }
    
            for key in dict.keys {
                num += dict[key]! * (dict[key]! - 1)
            }
        }
        return num
    }
}
