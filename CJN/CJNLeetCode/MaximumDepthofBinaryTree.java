/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
      public  int maxDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.right==null&&root.left==null) return 1;
        return getDepth(root,0);
    }

    private  int getDepth(TreeNode treeNode,Integer depth){
        if (treeNode!=null){
            depth=depth+1;
            if (treeNode.left!=null&&treeNode.right!=null){
                int left = getDepth(treeNode.left,depth);
                int right = getDepth(treeNode.right,depth);
                depth=Math.max(left,right);
            }else if (treeNode.left!=null){
               depth=getDepth(treeNode.left,depth);
            }else if (treeNode.right!=null){
                depth = getDepth(treeNode.right,depth);
            }
        }
        return depth;
    }
}
