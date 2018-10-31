package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Preorder_Traversal {

    //给定一个二叉树，返回它的 前序 遍历
    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        preorder(root,list);
//        return list;
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        while(node != null) {
            list.add(node.val);
            if (node.right != null) {
                rights.push(node.right);
            }
            node = node.left;
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return list;
    }
    void preorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        list.add(node.val);
        preorder(node.left,list);
        preorder(node.right,list);
    }
}
