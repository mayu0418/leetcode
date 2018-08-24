package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {

	public List<String> generateParenthesis(int n) {
		List<String> list = new ArrayList<String>();
		test(list, 0, 0, n, "");
        return list;
    }
	
	void test (List<String> list,int open,int close,int max,String s) {
		if (s.length() == max * 2) {
			list.add(s);
			return;
		}
		if (open < max) {
			test(list, open + 1, close, max, s + "(");
		}
		if (close < open) {
			test(list, open, close + 1, max, s + ")");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
