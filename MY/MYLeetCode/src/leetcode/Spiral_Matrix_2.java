package leetcode;

public class Spiral_Matrix_2 {

	/*
	给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
	示例:
	输入: 3
	输出:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]
	*/
			
	public static int[][] generateMatrix(int n) {
        int[][] ary = new int[n][n];
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;
        int cur = 0;
        while (left <= right && top <= bottom) {
			for (int i = left; i <= right; i++) {
				ary[top][i] = ++cur;
			}
			top++;
			for (int i = top; i <= bottom; i++) {
				ary[i][right] = ++cur;
			}
			right--;
			for (int i = right; i >= left; i--) {
				ary[bottom][i] = ++cur;
			}
			bottom--;
			for (int i = bottom; i >= top; i--) {
				ary[i][left] = ++cur;
			}
			left++;
		}
        return ary;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spiral_Matrix_2.generateMatrix(3);
	}

}
