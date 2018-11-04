package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_Largest_Value_in_Each_Tree_Row {
    //您需要在二叉树的每一行中找到最大的值。
    public List<Integer> largestValues(TreeNode root) {
        List list = new ArrayList();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ((LinkedList) queue).add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    ((LinkedList<TreeNode>) queue).add(node.left);
                }
                if (node.right != null) {
                    ((LinkedList<TreeNode>) queue).add(node.right);
                }
                max = Math.max(max,node.val);
            }
            list.add(max);
        }
        return list;
    }
}
