package leetcode;

public class Add_Digits {

    /*
    给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
    示例:
    输入: 38
    输出: 2
    解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
    */
    public static int addDigits(int num) {
        String s = String.valueOf(num);
        while (s.length() > 1) {
            char[] cAry = s.toCharArray();
            int i = 0;
            for (Character c : cAry) {
                i += (c - '0');
            }
            s = String.valueOf(i);
        }
        return  Integer.valueOf(s);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.print(addDigits(38));
    }
}
