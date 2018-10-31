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
        while(root != null) {
            list.add(root.val);
            if (root.right != null) {
                rights.push(root.right);
            }
            root = root.left;
            if (root == null && !rights.isEmpty()) {
                root = rights.pop();
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
