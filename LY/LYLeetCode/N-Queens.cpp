//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
#include <stdio.h>
#include <iostream>
//是否合法
bool isValid(char **square, int row, int col, int n)
{
    //列
    for(int i = 0; i < row; i++)
        if(square[i][col] == 'Q')return false;
    //左侧对角线
    for(int i = row-1, j=col-1; i >= 0 && j >= 0; i--,j--)
        if(square[i][j] == 'Q')return false;
    //右侧对角线
    for(int i = row-1, j=col+1; i >= 0 && j < n; i--,j++)
        if(square[i][j] == 'Q')return false;
    return true;
}

void queens(char **square, int n, int row,int *answerCount)
{
    if(row == n)
    {
        (*answerCount)++;
        return;
    }
    for(int col = 0; col < n; col++)
        if(isValid(square, row, col,n))
        {
            square[row][col] = 'Q';
            queens(square, n, row+1,answerCount);
            square[row][col] = '.';
        }
}

int totalNQueens(int n) {
    int answerCount=0;
    char **square=(char**)malloc(sizeof(char*)*n);
    for (int i=0; i<n; i++) {
        square[i]=(char *)malloc(sizeof(char)*n);
        for (int j=0; j<n; j++) {
            square[i][j]='.';
        }
    }
    queens(square, n, 0,&answerCount);
    return answerCount;
}

int main(int argc, const char * argv[]) {
    printf("%d",totalNQueens(4));
    return 0;
}
