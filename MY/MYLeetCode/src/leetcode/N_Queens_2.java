package leetcode;

public class N_Queens_2 {

/*
	n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
	给定一个整数 n，返回 n 皇后不同的解决方案的数量。
	横竖线&斜线上不能有相同的
*/	
	public int totalNQueens(int n) {
        int[] ary = new int[n];
		return test(ary, 0);
    }
	
	private int test(int[] ary,int idx) {
		if (ary.length == idx) {
			return 1;
		}
		int res = 0;
		for (int i = 0; i < ary.length; i++) {
			if (verify(ary, idx, i)) {
				ary[idx] = i;
				res += test(ary, idx + 1);
			}
		}
		return res;
	}
	
	private boolean verify(int[] ary,int idx,int curI) {
		for (int i = 0; i < idx; i++) {
			if (ary[i] == curI) return false;
			if (Math.abs(ary[i] - curI) == Math.abs(i - idx)) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
