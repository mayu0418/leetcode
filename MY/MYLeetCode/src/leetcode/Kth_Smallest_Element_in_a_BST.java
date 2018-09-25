package leetcode;

import java.util.ArrayList;

//二叉搜索树中第K小的元素
public class Kth_Smallest_Element_in_a_BST {

    public int kthSmallest(TreeNode root, int k) {
        ArrayList aryList = new ArrayList();
        test(root,aryList);
        return (int)aryList.get(k - 1);
    }
    void test(TreeNode node, ArrayList aryList) {
        if (node == null) return;
        test(node.left,aryList);
        aryList.add(node.val);
        test(node.right,aryList);
    }
    

}
