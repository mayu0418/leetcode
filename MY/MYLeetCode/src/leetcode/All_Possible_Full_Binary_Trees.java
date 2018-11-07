package leetcode;

import java.util.ArrayList;
import java.util.List;

public class All_Possible_Full_Binary_Trees {

    /*
    满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
    返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
    答案中每个树的每个结点都必须有 node.val=0。
    */
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<>();
        if (N % 2 == 0) return list;
        if (N == 1) {
            list.add(new TreeNode(0));
            return list;
        }
        for (int leftNum = 1; leftNum <= N-1; leftNum += 2) {
            List<TreeNode> fLeft = allPossibleFBT(leftNum);
            List<TreeNode> fRight = allPossibleFBT(N-leftNum-1);
            for (TreeNode left: fLeft) {
                for (TreeNode right: fRight) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }

        return list;
    }
}
