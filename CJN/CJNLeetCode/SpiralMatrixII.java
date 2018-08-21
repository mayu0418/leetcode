class Solution {
    public int[][] generateMatrix(int n) {
         int[][] matrix= new int[n][n];
        int count=1;
        int i=0;
        int j=0;
        matrix[i][j]=count++;
        while(count<=Math.pow(n,2)){
            while(j<matrix[i].length-1&&matrix[i][j+1]==0)
                matrix[i][++j]=count++;
            while(i<matrix.length-1 && matrix[i+1][j]==0)
                matrix[++i][j]=count++;
            while(j>0 && matrix[i][j-1]==0)
                matrix[i][--j]=count++;
            while(i>0&&matrix[i-1][j]==0)
                matrix[--i][j]=count++;
        }
        return matrix;
    }
}
