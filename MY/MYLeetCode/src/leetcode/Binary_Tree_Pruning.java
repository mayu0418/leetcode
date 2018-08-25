package leetcode;

public class Binary_Tree_Pruning {

	/*
	给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
	返回移除了所有不包含 1 的子树的原二叉树。
	( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
	示例1:
	输入: [1,null,0,0,1]
	输出: [1,null,0,null,1]
	解释: 
	只有红色节点满足条件“所有不包含 1 的子树”。
	右图为返回的答案。
	示例2:
	输入: [1,0,1,0,0,0,1]
	输出: [1,null,1,null,1]
	示例3:
	输入: [1,1,0,1,1,0,1,0]
	输出: [1,1,0,1,1,null,1]
	说明:
	给定的二叉树最多有 100 个节点。
	每个节点的值只会为 0 或 1 。
	*/
	public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
			return null;
		}
        return test(root);
    }
	
	TreeNode test(TreeNode node) {
		if (node == null || !hasOne(node)) {
			return null;
		}
		if (!hasOne(node.left)) {
			node.left = null;
		} else {
			test(node.left);
		}
		if (!hasOne(node.right)) {
			node.right = null;
		} else {
			 test(node.right);
		}
		return node;
	}
	
	Boolean hasOne(TreeNode node) {
		if (node == null) {
			return false;
		}
		if (node.val == 1 || hasOne(node.left) || hasOne(node.right)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
