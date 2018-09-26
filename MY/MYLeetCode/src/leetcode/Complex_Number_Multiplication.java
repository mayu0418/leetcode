package leetcode;

/*
        给定两个表示复数的字符串。
        返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
        示例 1:
        输入: "1+1i", "1+1i"
        输出: "0+2i"
        解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
        示例 2:
        输入: "1+-1i", "1+-1i"
        输出: "0+-2i"
        解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
        注意:
        输入字符串不包含额外的空格。
        输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。
*/



public class Complex_Number_Multiplication {
    public static String complexNumberMultiply(String a, String b) {
        String[] resStr1 = format(a);
        String[] resStr2 = format(b);
        
        return "" + 
                (Integer.valueOf(resStr1[0]) * Integer.valueOf(resStr2[0]) - Integer.valueOf(resStr1[1]) * Integer.valueOf(resStr2[1]))
                + "+" +
                (Integer.valueOf(resStr1[0]) * Integer.valueOf(resStr2[1]) + Integer.valueOf(resStr1[1]) * Integer.valueOf(resStr2[0]))
                + "i";
    }
    static String[] format(String s) {
        String[] resAry = new String[2];
        int idx = s.indexOf("+");
//        String[] sAry = s.split("\+");
        resAry[0] = s.substring(0,idx);
        String cNumStr = s.substring(idx + 1);
        cNumStr = cNumStr.split("i")[0];
        resAry[1] = cNumStr;
        return resAry;
    }
    static void main(String[] sAry) {
        Complex_Number_Multiplication.complexNumberMultiply("1+1i","1+1i");
    }
}



