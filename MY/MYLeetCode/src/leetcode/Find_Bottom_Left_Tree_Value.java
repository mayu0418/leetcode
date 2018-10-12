package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Find_Bottom_Left_Tree_Value {
    //给定一个二叉树，找出在树的最后一行找到最左边的值
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        TreeNode preLeftNode = root;
        while (!queue.isEmpty()) {
            preLeftNode = queue.peek();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) ((LinkedList<TreeNode>) queue).add(node.left);
                if (node.right != null) ((LinkedList<TreeNode>) queue).add(node.right);
            }
        }
        return preLeftNode.val;
    }
}
