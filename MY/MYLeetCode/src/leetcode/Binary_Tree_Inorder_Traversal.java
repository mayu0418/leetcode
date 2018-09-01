package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Inorder_Traversal {

	/*
	给定一个二叉树，返回它的中序 遍历。
	示例:
	输入: [1,null,2,3]
	   1
	    \
	     2
	    /
	   3

	输出: [1,3,2]
	*/
			
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> aryList = new ArrayList<Integer>();
        test(root, aryList);
        return aryList;
    }
	void test(TreeNode node,List<Integer>aryList) {
		if (node == null) {
			return ;
		}
		test(node.left, aryList);
		aryList.add(node.val);
		test(node.right, aryList);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
