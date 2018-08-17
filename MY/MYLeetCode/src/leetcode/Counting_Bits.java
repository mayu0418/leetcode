package leetcode;

public class Counting_Bits {

/*	
	给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
	示例 1:
	输入: 2
	输出: [0,1,1]
	示例 2:
	输入: 5
	输出: [0,1,1,2,1,2]
*/
	
	public int[] countBits(int num) {
		int[] intAry = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			String numStr = Integer.toBinaryString(i);
			int count = 0;
			for (Character c : numStr.toCharArray()) {
				if (c == '1') {
					count++;
				}
			}
			intAry[i] = count;
		}
		return intAry;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
