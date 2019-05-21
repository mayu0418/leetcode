package leetcode;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */

public class SearchForARange {
//    public int[] searchRange(int[] A, int target) {
//        int start = Solution.firstGreaterEqual(A, target);
//        if (start == A.length || A[start] != target) {
//            return new int[]{-1, -1};
//        }
//        return new int[]{start, Solution.firstGreaterEqual(A, target + 1) - 1};
//    }
//
//    //find the first number that is greater than or equal to target.
//    //could return A.length if target is greater than A[A.length-1].
//    //actually this is the same as lower_bound in C++ STL.
//    private static int firstGreaterEqual(int[] A, int target) {
//        int low = 0, high = A.length;
//        while (low < high) {
//            int mid = low + ((high - low) >> 1);
//            //low <= mid < high
//            if (A[mid] < target) {
//                low = mid + 1;
//            } else {
//                //should not be mid-1 when A[mid]==target.
//                //could be mid even if A[mid]>target because mid<high.
//                high = mid;
//            }
//        }
//        return low;
//    }
}
