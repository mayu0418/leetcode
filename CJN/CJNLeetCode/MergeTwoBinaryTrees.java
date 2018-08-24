
class Solution {
     public  TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = new TreeNode(0);
        if (t1==null) return t2;
        if (t2==null) return t1;
        preOrder(t1,t2,root);
        return root;
    }

    private  void preOrder(TreeNode t1, TreeNode t2, TreeNode root) {
        if (t1 != null && t2 != null) {
            root.val = t1.val + t2.val;
            if (t1.left != null && t2.left != null) {
                root.left = new TreeNode(0);
                preOrder(t1.left, t2.left, root.left);
            }else if (t1.left==null){
                root.left = t2.left;
            }else {
                root.left = t1.left;
            }
            if (t1.right != null && t2.right != null){
                root.right = new TreeNode(0);
                preOrder(t1.right,t2.right,root.right);
            }else if (t1.right==null){
                root.right = t2.right;
            }else {
                root.right = t1.right;
            }
        }
    }
}
