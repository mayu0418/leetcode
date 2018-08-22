/*
 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 
 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 
 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 
 返回尽可能高的分数。
 */
#include <iostream>

int matrixScore(int** A, int ARowSize, int *AColSizes) {
    for (int i=0; i<ARowSize; i++) {
        if (A[i][0] == 0) {
            for (int j=0; j<AColSizes[0]; j++) {
                A[i][j]=!A[i][j];
            }
        }
    }
    
    for (int j=1; j<AColSizes[0]; j++) {
        int count1=0;
        for (int i=0; i<ARowSize; i++) {
            count1+=A[i][j];
        }
        if (count1<AColSizes[0]/2.0) {
            for (int i=0; j<ARowSize; j++) {
                A[i][j]=!A[i][j];
            }
        }
    }
    //计算结果
    int result=0;
    for (int i=0; i<ARowSize; i++) {
        int tempSum=0;
        for (int j=0; j<AColSizes[0]; j++) {
            tempSum<<=1;
            tempSum+=A[i][j];
        }
        result+=tempSum;
    }
    return result;
}

int main(int argc, const char * argv[]) {
    int a[3][4] = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
    int **A=(int **)malloc(sizeof(int*)*3);
    for (int i=0; i<3; i++) {
        A[i]=(int *)malloc(sizeof(int)*4);
        for (int j=0; j<4; j++) {
            a[i][j]=a[i][j];
        }
    }
    int ARowSize=3;
    int *AColSizes =(int *)malloc(sizeof(int)*3);
    for (int i=0; i<3; i++) {
        AColSizes[i]=4;
    }
    printf("%d",matrixScore(A, ARowSize, AColSizes));
    
    return 0;
}
