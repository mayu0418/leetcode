package leetcode;

import java.util.ArrayList;
import java.util.List;

public class All_Paths_From_Source_to_Target {

	/*
	给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）
	二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了a→b你就不能从b→a）空就是没有下一个结点了。
	示例:
	输入: [[1,2], [3], [3], []] 
	输出: [[0,1,3],[0,2,3]] 
	解释: 图是这样的:
	0--->1
	|    |
	v    v
	2--->3
	这有两条路: 0 -> 1 -> 3 和 0 -> 2 -> 3.
	提示:
	结点的数字会在范围 [2, 15] 内。
	你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。
	*/
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        ArrayList<Integer> aryList = new ArrayList<Integer>();
        test(lists, aryList, graph, 0);
        return lists;
    }
	
	void test(List<List<Integer>> lists,ArrayList<Integer> list,int[][] graph,int idx) {
		if (idx == graph.length - 1) {
			list.add(idx);
			lists.add(list);
			return;
		}
		int[] curCanGOAry = graph[idx];
		if (curCanGOAry.length < 1) {
			return;
		}
		for (int i : curCanGOAry) {
			ArrayList<Integer> aryList = new ArrayList<Integer>();
			aryList.addAll(list);
			aryList.add(idx);
			test(lists, aryList, graph, i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
