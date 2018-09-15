package leetcode;

import java.util.ArrayList;

public class Single_Number_3 {

    /*
    给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
    示例 :
    输入: [1,2,1,3,2,5]
    输出: [3,5]
    */
    
    public int[] singleNumber(int[] nums) {
        ArrayList<String> aryList = new ArrayList<String>();
        for (int i : nums) {
            if (aryList.contains(i + "")) {
                aryList.remove(i + "");
            } else {
                aryList.add(i + "");
            }
        }
        int[] intAry = new int[2];
        intAry[0] = Integer.valueOf(aryList.get(0));
        intAry[1] = Integer.valueOf(aryList.get(1));
        return intAry;
    }
}
