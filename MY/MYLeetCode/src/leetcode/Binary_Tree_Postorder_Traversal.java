package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Postorder_Traversal {

	/*
	给定一个二叉树，返回它的 后序 遍历。
	示例:
	输入: [1,null,2,3]  
	   1
	    \
	     2
	    /
	   3 
	输出: [3,2,1]
	*/
			
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        test(root, list);
        return list;
    }
	void test(TreeNode node,List<Integer> list) {
		if (node == null) {
			return;
		}
		test(node.left, list);
		test(node.right, list);
		list.add(node.val);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
