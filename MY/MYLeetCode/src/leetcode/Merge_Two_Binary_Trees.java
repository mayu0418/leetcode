package leetcode;

public class Merge_Two_Binary_Trees {

	/*
	给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
	你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
	示例 1:
	输入: 
		Tree 1                     Tree 2                  
	          1                         2                             
	         / \                       / \                            
	        3   2                     1   3                        
	       /                           \   \                      
	      5                             4   7                  
	输出: 
	合并后的树:
		     3
		    / \
		   4   5
		  / \   \ 
		 5   4   7
	注意: 合并必须从两个树的根节点开始。
	*/
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}
		if (t1 == null) {
			return t2;
		}
		if (t2 == null) {
			return t1;
		}
		TreeNode node = new TreeNode(t1.val + t2.val);
		node.left = mergeTrees(t1.left, t2.left);
		node.right = mergeTrees(t1.right, t2.right);
		return node;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(5);
		node.left = node1;
		node.right = node2;
		node1.left = node3;
		
		TreeNode node10 = new TreeNode(2);
		TreeNode node11 = new TreeNode(1);
		TreeNode node12 = new TreeNode(3);
		TreeNode node13 = new TreeNode(4);
		TreeNode node14 = new TreeNode(7);
		node10.left = node11;
		node10.right = node12;
		node11.right = node13;
		node12.right = node14;
		
		mergeTrees(node,node10);
	}

}
