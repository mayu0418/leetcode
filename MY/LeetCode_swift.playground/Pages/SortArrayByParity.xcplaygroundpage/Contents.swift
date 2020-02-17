/**
* Question Link: https://leetcode.com/problems/sort-array-by-parity/
* Primary idea: traverse the array and insert Even into the 0 th index and odd into the last index
*
* Time Complexity: O(n), Space Complexity: O(n)
*给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。

你可以返回满足此条件的任何数组作为答案。
*/

import Foundation

var str = "Hello, playground"

//: [Next](@next)
class SortArrayByParity {
    func sortArrayByParity(_ A: [Int]) -> [Int] {
        return A.enumerated().reduce(into: [Int]()) { (acc, arg) in
            let (_, value) = arg
            acc.insert(value, at: value.isMultiple(of: 2) ? 0 : acc.count)
        }
    }
}
