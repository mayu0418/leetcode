package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Maximum_Binary_Tree {

/*	
	给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
	二叉树的根是数组中的最大元素。
	左子树是通过数组中最大值左边部分构造出的最大二叉树。
	右子树是通过数组中最大值右边部分构造出的最大二叉树。
	通过给定的数组构建最大二叉树，并且输出这个树的根节点。
	Example 1:
	输入: [3,2,1,6,0,5]
	输入: 返回下面这棵树的根节点：

	      6
	    /   \
	   3     5
	    \    / 
	     2  0   
	       \
	        1
	注意:
	给定的数组的大小在 [1, 1000] 之间。
*/
	
	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode node = recursion(nums, 0, nums.length - 1);
		return node;
    }
	
	private static TreeNode recursion(int[] nums,int start,int end) {
		if (start == end) {
			return new TreeNode(nums[start]);
		} else if (start > end) {
			return null;
		}
		int curMax = getMaxIdx(nums, start, end);
		TreeNode node = new TreeNode(nums[curMax]);
		node.left = recursion(nums, start, curMax - 1);
		node.right = recursion(nums, curMax + 1, end);
		return node;
	}
	
	private static int getMaxIdx(int[] nums,int start,int end) {
		int maxIdx = start;
		for (int i = start; i <= end; i++) {
			if (nums[i] > nums[maxIdx]) {
				maxIdx = i;
			}
		}
		return maxIdx;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intAry = {3,2,1,6,0,5};
//		constructMaximumBinaryTree(intAry);
		System.out.println(constructMaximumBinaryTree(intAry));
	}

}
