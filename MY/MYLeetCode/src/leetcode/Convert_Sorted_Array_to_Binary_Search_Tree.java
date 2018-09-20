package leetcode;

//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

public class Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return test(nums,0,nums.length - 1);
    }

    TreeNode test(int[] nums,int start,int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = test(nums,start,mid - 1);
        node.right = test(nums,mid + 1,end);
        return node;
    }
}
