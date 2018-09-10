package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Different_Ways_to_Add_Parentheses {

	/*
	给定一个含有数字和运算符的字符串，
	为表达式添加括号，
	改变其运算优先级以求出不同的结果。
	你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
	示例 1:
	输入: "2-1-1"
	输出: [0, 2]
	解释: 
	((2-1)-1) = 0 
	(2-(1-1)) = 2
	示例 2:
	输入: "2*3-4*5"
	输出: [-34, -14, -10, -10, 10]
	解释: 
	(2*(3-(4*5))) = -34 
	((2*3)-(4*5)) = -14 
	((2*(3-4))*5) = -10 
	(2*((3-4)*5)) = -10 
	(((2*3)-4)*5) = 10
	*/
	public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '+' ||
				input.charAt(i) == '-' ||
				input.charAt(i) == '*') {
				String string = input.substring(0, i);
				String string2 = input.substring(i + 1);
				List<Integer> list1 = diffWaysToCompute(string);
				List<Integer> list2 = diffWaysToCompute(string2);
				for (Integer integer1 : list1) {
					for (Integer integer2 : list2) {
						switch (input.charAt(i)) {
							case '+':
								list.add(integer1 + integer2);
								break;
							case '-':
								list.add(integer1 - integer2);
								break;
							case '*':
								list.add(integer1 * integer2);
								break;
						}
					}
				}
			}
		}
		if (list.size() == 0) {
			list.add(Integer.valueOf(input));
		}
		return list;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		diffWaysToCompute("2-1-1");
	}

}
