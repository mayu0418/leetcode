package leetcode;

import java.util.ArrayList;

public class Flatten_Binary_Tree_to_Linked_List {

    /*
    给定一个二叉树，原地将它展开为链表。
    例如，给定二叉树

                1
               / \
              2   5
             / \   \
            3   4   6
    将其展开为：

            1
             \
              2
               \
                3
                 \
                  4
                   \
                    5
                     \
                      6
    */
    public void flatten(TreeNode root) {
        ArrayList<TreeNode> list = new ArrayList();
        preOrder(root,list);
        TreeNode curNode = root;
        for (int i = 1; i < list.size(); i++) {
            curNode.left = null;
            curNode.right = list.get(i);
            curNode = curNode.right;
        }
    }

    void preOrder(TreeNode node, ArrayList list) {
        if (node == null) return;
        list.add(node);
        preOrder(node.left,list);
        preOrder(node.right, list);
    }

}
