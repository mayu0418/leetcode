package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum {

	/*
	给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
	candidates 中的数字可以无限制重复被选取。
	说明：
	所有数字（包括 target）都是正整数。
	解集不能包含重复的组合。 
	示例 1:
	输入: candidates = [2,3,6,7], target = 7,
	所求解集为:
	[
	  [7],
	  [2,2,3]
	]
	示例 2:
	输入: candidates = [2,3,5], target = 8,
	所求解集为:
	[
	  [2,2,2,2],
	  [2,3,3],
	  [3,5]
	]
	*/
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
		ArrayList<Integer> aryList = new ArrayList<>();
		test(list, aryList, candidates, target, 0);
		return list;
    }

    void test(List<List<Integer>> list,ArrayList<Integer> aryList,int[] candidates,int remain,int start) {
		if (remain > 0) {
            for (int i = start; i < candidates.length; i++) {
                aryList.add(candidates[i]);
                test(list, aryList, candidates, remain - candidates[i], i);
                aryList.remove(aryList.size() - 1);
            }
		} else if (remain == 0) {
			list.add(new ArrayList<>(aryList));
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("xxxxxx");
	}

}
