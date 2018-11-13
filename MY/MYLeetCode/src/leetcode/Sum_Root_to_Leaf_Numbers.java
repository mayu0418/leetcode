package leetcode;

import java.util.ArrayList;

public class Sum_Root_to_Leaf_Numbers {

    /*
    求根到叶子节点数字之和
    给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
    例如，从根到叶子节点路径 1->2->3 代表数字 123。
    计算从根到叶子节点生成的所有数字之和。
    说明: 叶子节点是指没有子节点的节点。
    */
    public int sumNumbers(TreeNode root) {
        ArrayList<String> aryList = new ArrayList<>();
        test(root, "",aryList);
        int i = 0;
        for (String s: aryList) {
            i += Integer.valueOf(s);
        }
        return i;
    }
    void test(TreeNode node, String str, ArrayList aryList) {
        if (node == null) {
            return;
        }
        String s = "" + str + node.val;
        if (node.left == null && node.right == null) {
            aryList.add(s);
        }
        if (node.left != null) {
            test(node.left, s, aryList);
        }

        if (node.right != null) {
            test(node.right, s, aryList);
        }
    }
}
