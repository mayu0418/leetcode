package leetcode;

public class Maximum_Depth_of_N_ary_Tree {
    public int maxDepth(Node root) {
        if (root == null) return  0;
        int count = 1;
        for (Node node : root.children) {
            count = Math.max(count, maxDepth(node) + 1);
        }
        return count; 
    }

}
