package leetcode;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
 */

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int[] resAry = new int[nums.length];
        resAry[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0;i--) {
            int max = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    max = Math.max(resAry[j] + 1,max);
                }
            }
            resAry[i] = max;
        }
        return resAry[0];
    }
    public static void main(String[] args) {
        int[] ary = {10,9,2,5,3,7,101,18};
        LongestIncreasingSubsequence.lengthOfLIS(ary);
    }
}
