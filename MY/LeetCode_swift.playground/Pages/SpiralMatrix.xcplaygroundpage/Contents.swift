//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)
/**
 * Question Link: https://leetcode.com/problems/spiral-matrix/
 * Primary idea: Use four index to get the right element during iteration
 *
 * Time Complexity: O(n^2), Space Complexity: O(1)
 *
 *
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 Example 1:

 Input:
 [
  [ 1, 2, 3 ],
  [ 4, 5, 6 ],
  [ 7, 8, 9 ]
 ]
 Output: [1,2,3,6,9,8,7,4,5]
 Example 2:

 Input:
 [
   [1, 2, 3, 4],
   [5, 6, 7, 8],
   [9,10,11,12]
 ]
 Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 螺旋矩阵
 */

class SpiralMatrix {
    func spiralOrder(_ matrix: [[Int]]) -> [Int] {
        var res = [Int]()
    
        guard matrix.count != 0 else {
            return res
        }
    
        var startX = 0
        var endX = matrix.count - 1
        var startY = 0
        var endY = matrix[0].count - 1
        
        while true {
            // top
            for i in startY ... endY {
                res.append(matrix[startX][i])
            }
            startX += 1
            if startX > endX {
                break
            }
            
            // right
            for i in startX ... endX {
                res.append(matrix[i][endY])
            }
            endY -= 1
            if startY > endY {
                break
            }
            
            // bottom
            for i in stride(from: endY, through: startY, by: -1) {
                res.append(matrix[endX][i])
            }
            endX -= 1
            if startX > endX {
                break
            }
            
            // left
            for i in stride(from: endX, through: startX, by: -1) {
                res.append(matrix[i][startY])
            }
            startY += 1
            if startY > endY {
                break
            }
        }
        
        return res
    }
}
