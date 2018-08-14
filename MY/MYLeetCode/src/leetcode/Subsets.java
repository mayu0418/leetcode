package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
/*
	给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
	说明：解集不能包含重复的子集。
	示例:
	输入: nums = [1,2,3]
	输出:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
*/		
	public static List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums.length < 1) {
			return list;
		}
        
        ArrayList<Integer> aryList = new ArrayList<Integer>();
        list.add(aryList);
        for (Integer integer : nums) {
        	int size = list.size();
			for (int i = 0; i < size; i++) {
				ArrayList<Integer> curList = new ArrayList<Integer>(list.get(i));
				curList.add(integer);
				list.add(curList);
			}
		}
        return list;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		
		System.out.println(Subsets.subsets(nums));
	}

}
