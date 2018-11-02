package leetcode;

import java.util.HashMap;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    //根据一棵树的中序遍历与后序遍历构造二叉树。
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return test(inorder,0,inorder.length - 1,postorder,0,postorder.length - 1,map);
    }
    TreeNode test(int[] inorder, int inStart, int inEnd, int[] postorder, int posStart, int posEnd, HashMap<Integer,Integer> map) {
        if (inStart > inEnd || posStart > posEnd) return null;
        TreeNode node = new TreeNode(postorder[posEnd]);
        int idx = map.get(postorder[posEnd]);
        node.left = test(inorder,inStart,idx - 1,postorder,posStart,posStart + idx - inStart - 1,map);
        node.right = test(inorder,idx + 1,inEnd,postorder,posStart + idx - inStart,posEnd - 1,map);
        return node;
    }

}
