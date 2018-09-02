package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	/*
	给定一个没有重复数字的序列，返回其所有可能的全排列。
	示例:
	输入: [1,2,3]
	输出:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
	*/
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		test(lists, new ArrayList<Integer>(), nums);
        return lists;
    }
	
	void test(List<List<Integer>> lists,List<Integer> list,int[] nums) {
		if (list.size() == nums.length) {
			lists.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i])) {
				continue;
			} else {
				list.add(nums[i]);
				test(lists, list, nums);
				list.remove(list.size() - 1);
			}
		}
	}
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
