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
   public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root,list);
        return list;
    }

    private void preOrder(TreeNode treeNode,List<Integer> list){
        if (treeNode!=null) {
            list.add(treeNode.val);
        }else return;
        preOrder(treeNode.left,list);
        preOrder(treeNode.right,list);
    }
}
