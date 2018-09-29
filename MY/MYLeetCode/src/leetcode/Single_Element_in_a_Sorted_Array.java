package leetcode;

public class Single_Element_in_a_Sorted_Array {
    /*
    给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
    示例 1:
    输入: [1,1,2,3,3,4,4,8,8]
    输出: 2
    示例 2:
    输入: [3,3,7,7,10,11,11]
    输出: 10
    注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
    */
    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid == 0 || mid == nums.length - 1) break;
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];
            if (nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            } else {
                if (mid % 2 == 1) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        return nums[start];
    }

    public static void main(String[] s) {
        int[] nums = {0,1,1};
        System.out.println(Single_Element_in_a_Sorted_Array.singleNonDuplicate(nums));
    }
}
