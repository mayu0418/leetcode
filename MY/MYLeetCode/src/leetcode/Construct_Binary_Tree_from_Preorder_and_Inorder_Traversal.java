package leetcode;

import java.util.HashMap;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
//根据一棵树的前序遍历与中序遍历构造二叉树。
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder==null||inorder==null||preorder.length==0||inorder.length==0||preorder.length!=inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return getNode(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, hashMap);
    }
    private TreeNode getNode(int[] pre,int pi,int pj,int[] in,int ni,int nj,HashMap<Integer, Integer> hashMap) {
        if (pi>pj) {
            return null;
        }
        int index = hashMap.get(pre[pi]);
        TreeNode node = new TreeNode(pre[pi]);
        node.left = getNode(pre, pi+1, pi+index-ni, in, ni, index-1, hashMap);
        node.right = getNode(pre, pi+index-ni+1, pj, in, index+1, nj, hashMap);
        return node;
    }
}
