package leetcode;

public class Invert_Binary_Tree {
	/*
	翻转一棵二叉树。
	示例：
	输入：
	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9
	输出：
	     4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1
	*/
	
	public TreeNode invertTree(TreeNode root) {
        return test(root);
    }
	TreeNode test(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode leftNode = test(root.left);
		root.left = test(root.right);
		root.right = leftNode;
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
