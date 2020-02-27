//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)
/**
 * Question Link: https://leetcode.com/problems/diagonal-traverse/
 * Primary idea: use sum to track matrix index, note to set lower and upper bound to avoid duplicates
 *
 * Time Complexity: O(mn), Space Complexity: O(1)
 *
 *Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

  

 Example:

 Input:
 [
  [ 1, 2, 3 ],
  [ 4, 5, 6 ],
  [ 7, 8, 9 ]
 ]

 Output:  [1,2,4,7,5,3,6,8,9]
 *
 */

class DiagonalTraverse {
    func findDiagonalOrder(_ matrix: [[Int]]) -> [Int] {
        var res = [Int]()
        
        guard matrix.count > 0 && matrix[0].count > 0 else {
            return res
        }
        
        let m = matrix.count, n = matrix[0].count
        var fromTop = false
        
        for sum in 0 ... m + n - 2 {
            if fromTop {
                for i in max(sum - n + 1, 0)...min(m - 1, sum) {
                    res.append(matrix[i][sum - i])
                }
            } else {
                for i in (max(sum - n + 1, 0)...min(m - 1, sum)).reversed() {
                    res.append(matrix[i][sum - i])
                }
            }
            
            fromTop = !fromTop
        }
        
        return res
    }
}
