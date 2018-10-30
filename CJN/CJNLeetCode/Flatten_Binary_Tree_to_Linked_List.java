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
    public  void flatten(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        changeNode(root,linkedList);
        for (int i=1;i<linkedList.size();i++){
            root.left = null;
            root.right = linkedList.get(i);
            root=root.right;
        }
    }
    private  void  changeNode(TreeNode root,LinkedList linkedList){
        if (root==null) return;
        linkedList.addLast(root);
        if (root.left!=null)changeNode(root.left,linkedList);
        if (root.right!=null) changeNode(root.right,linkedList);
    }
}
