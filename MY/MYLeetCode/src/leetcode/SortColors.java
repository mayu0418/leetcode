package leetcode;

import java.util.ArrayList;

public class SortColors {
    /*
    Given an array with n objects colored red, white or blue,
    sort them in-place so that objects of the same color are adjacent,
    with the colors in the order red, white and blue.
    Here, we will use the integers 0, 1,
    and 2 to represent the color red, white, and blue respectively.
    Note: You are not suppose to use the library's sort function for this problem.
    Example:
    Input: [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
    */
    static int idx = 0;
    public static void sortColors(int[] nums) {
//        ArrayList aryList = Arrays.asList(nums);
        ArrayList aryList = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            aryList.add(nums[i]);
        }

        for (int i = 0; i < aryList.size();) {
            if (aryList.get(i).equals(0)) {
                aryList.remove(i);
                aryList.add(0,0);
                i++;
            } else if (aryList.get(i).equals(2)) {
                aryList.remove(i);
                aryList.add(2);
                idx++;
                if (idx >= aryList.size()) break;;
            } else {
                i++;
            }
        }
        for (int i = 0; i< aryList.size(); i++) {
            nums[i] = (int) aryList.get(i);
        }
        idx = 0;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {2,0,2,1,1,0};
        SortColors.sortColors(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
