//: [Previous](@previous)

import Foundation

var str = "Hello, playground"

//: [Next](@next)
/**
 * Question Link: https://leetcode.com/problems/rotate-image/
 * Primary idea: Go from clockwise and from outside to inside, use offset for convenience
 *
 * Time Complexity: O(n^2), Space Complexity: O(1)
 *
 *You are given an n x n 2D matrix representing an image.

 Rotate the image by 90 degrees (clockwise).

 Note:

 You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 Example 1:

 Given input matrix =
 [
   [1,2,3],
   [4,5,6],
   [7,8,9]
 ],

 rotate the input matrix in-place such that it becomes:
 [
   [7,4,1],
   [8,5,2],
   [9,6,3]
 ]
 Example 2:

 Given input matrix =
 [
   [ 5, 1, 9,11],
   [ 2, 4, 8,10],
   [13, 3, 6, 7],
   [15,14,12,16]
 ],

 rotate the input matrix in-place such that it becomes:
 [
   [15,13, 2, 5],
   [14, 3, 4, 1],
   [12, 6, 8, 9],
   [16, 7,10,11]
 ]
 *
 *
 */

class RotateImage {
    func rotate(_ matrix: inout [[Int]]) {
        let n = matrix.count
        
        for layer in 0 ..< n / 2 {
            let start = layer, end = n - layer - 1
            for i in start ..< end {
                let offset = i - start
                (matrix[start][i], matrix[i][end], matrix[end][end - offset], matrix[end - offset][start]) =
                    (matrix[end - offset][start], matrix[start][i], matrix[i][end], matrix[end][end - offset])
            }
        }
    }
}
