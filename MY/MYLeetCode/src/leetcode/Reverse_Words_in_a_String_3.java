package leetcode;

public class Reverse_Words_in_a_String_3 {

	/*
	给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
	示例 1:
	输入: "Let's take LeetCode contest"
	输出: "s'teL ekat edoCteeL tsetnoc" 
	注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
	*/
	
	public String reverseWords(String s) {
		String[] sAry = s.split(" ");
		String str = "";
//		for (String string : sAry) {
//			str += new StringBuffer(string).reverse().toString() + " ";
//		}
		for (int i = 0; i < sAry.length; i++) {
			str += new StringBuffer(sAry[i]).reverse().toString();
			if (i != (sAry.length - 1)) {
				str += " ";
			}
		}
		return str;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
