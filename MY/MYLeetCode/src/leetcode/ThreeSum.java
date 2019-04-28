package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//给定数组，找出3个数和为0的组合
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        Set resList = new HashSet();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    resList.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return new ArrayList<>(resList);
    }
}
