/*
 64. 最小路径和
 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 
 说明：每次只能向下或者向右移动一步。
 输入:
 [
 [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 输出: 7
 解释: 因为路径 1→3→1→1→1 的总和最小。
 */

#include <iostream>

int minPathSum(int** grid, int gridRowSize, int gridColSize) {
    int **lengthGrid=(int **)malloc(sizeof(int*)*gridRowSize);
    for (int i=0; i<gridRowSize; i++) {
        lengthGrid[i]=(int *)malloc(sizeof(int)*gridColSize);
    }
    //开始计算到每个点的最小距离
    for (int i=0; i<gridRowSize; i++) {
        for (int j=0; j<gridColSize; j++) {
            if (i==0&&j==0) {
                lengthGrid[i][j]=grid[i][j];
            } else if (i==0) {
                lengthGrid[i][j]=lengthGrid[i][j-1]+grid[i][j];
            } else if (j==0) {
                lengthGrid[i][j]=lengthGrid[i-1][j]+grid[i][j];
            } else {
                //不在矩形边界的情况
                if (lengthGrid[i-1][j]>lengthGrid[i][j-1]) {
                    lengthGrid[i][j]=lengthGrid[i][j-1]+grid[i][j];
                } else {
                    lengthGrid[i][j]=lengthGrid[i-1][j]+grid[i][j];
                }
            }
        }
    }
    return lengthGrid[gridRowSize-1][gridColSize-1];
}

int main(int argc, const char * argv[]) {
    int a[3][3]={{1,3,1},{1,5,1},{4,2,1}};
    int gridRowSize = 3;
    int gridColSize = 3;
    int **grid=(int **)malloc(sizeof(int*)*gridRowSize);
    for (int i=0; i<gridRowSize; i++) {
        grid[i]=(int *)malloc(sizeof(int)*gridColSize);
    }
    for (int i=0; i<gridRowSize; i++) {
        for (int j=0; j<gridColSize; j++) {
            grid[i][j]=a[i][j];
        }
    }
    minPathSum(grid, gridRowSize, gridColSize);
    return 0;
}
