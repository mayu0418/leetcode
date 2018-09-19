package leetcode;


/*
给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
你可以返回满足此条件的任何数组作为答案。
*/

public class Sort_Array_By_Parity {
    public int[] sortArrayByParity(int[] A) {
        int[] ary = new int[A.length];
        int start = 0;
        int end = ary.length - 1;
        for (int num : A) {
//            num % 2 == 0 ? (ary[end--] = num) : (ary[start++] = num);
            if (num % 2 != 0) {
                ary[end--] = num;
            } else {
                ary[start++] = num;
            }
        }
        return ary;
    }
    
    static  void main(String[] sAry) {
        
    }
    
}
