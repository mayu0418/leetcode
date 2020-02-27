//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)
/**
 * Question Link: https://leetcode.com/problems/spiral-matrix-ii/
 * Primary idea: Go from clockwise and populate number, remember to handle the center one
 *
 * Time Complexity: O(n^2), Space Complexity: O(1)
 *
 *Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 Example:

 Input: 3
 Output:
 [
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
 ]
 */

class SpiralMatrixII {
    func generateMatrix(_ n: Int) -> [[Int]] {
        guard n > 0 else {
            return [[Int]]()
        }
    
        var num = 1
        var res = Array(repeating: Array(repeating: 0, count: n), count: n)
        
        for layer in 0 ..< n / 2 {
            let start = layer
            let end = n - layer - 1
            
            // top
            for i in start ..< end {
                res[start][i] = num
                num += 1
            }
            
            // right
            for i in start ..< end {
                res[i][end] = num
                num += 1
            }
            
            // bottom
            for i in stride(from: end, to: start, by: -1) {
                res[end][i] = num
                num += 1
            }
            
            // left
            for i in stride(from: end, to: start, by: -1) {
                res[i][start] = num
                num += 1
            }
        }
        
        // handle the center one
        if n % 2 != 0 {
            res[n / 2][n / 2] = n * n
        }
        
        return res
    }
}
