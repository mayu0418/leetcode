package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Self_Dividing_Numbers {

	/*
	自除数 是指可以被它包含的每一位数除尽的数。
	例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
	还有，自除数不允许包含 0 。
	给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数
	示例 1：
	输入： 
	上边界left = 1, 下边界right = 22
	输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
	注意：
	每个输入参数的边界满足 1 <= left <= right <= 10000。
	*/
	
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
			if (isSelfDividingNumber(i)) {
				list.add(i);
			}
		}
        return list;
    }
	
	boolean isSelfDividingNumber(Integer n) {
		char[] cAry = n.toString().toCharArray();
		boolean isSelfDividingNumber = true;
		for (char c : cAry) {
			if (c == '0' || n % (c - '0') != 0) {
				isSelfDividingNumber = false;
				break;
			}
		}
		return isSelfDividingNumber;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
