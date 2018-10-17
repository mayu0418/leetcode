package leetcode;

public class Product_of_array_except_self {

    /*
    给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
    示例:
    输入: [1,2,3,4]
    输出: [24,12,8,6]
    说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
    */
    public int[] productExceptSelf(int[] nums) {
        int[] leftAry = new int[nums.length];
        int[] rightAry = new int[nums.length];
        int[] resAry = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftAry[i] = 1;
            } else {
                leftAry[i] = leftAry[i - 1] * nums[i - 1];
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                rightAry[i] = 1;
            } else {
                rightAry[i] = rightAry[i + 1] * nums[i + 1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            resAry[i] = leftAry[i] * rightAry[i];
        }
        return resAry;
    }
}
