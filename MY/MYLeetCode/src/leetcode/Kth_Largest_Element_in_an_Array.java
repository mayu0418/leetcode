package leetcode;

import java.util.Arrays;

public class Kth_Largest_Element_in_an_Array {

    /*
    在未排序的数组中找到第 k 个最大的元素。
    请注意，你需要找的是数组排序后的第 k 个最大的元素，
    而不是第 k 个不同的元素。
    */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return  nums[nums.length - k];
    }
}
