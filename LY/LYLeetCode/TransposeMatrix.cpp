/*给定一个矩阵 A， 返回 A 的转置矩阵。
 
 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 输入：[[1,2,3],[4,5,6],[7,8,9]]
 输出：[[1,4,7],[2,5,8],[3,6,9]]
 
 输入：[[1,2,3],[4,5,6]]
 输出：[[1,4],[2,5],[3,6]]
 */

#include <iostream>

int** transpose(int** A, int ARowSize, int *AColSizes, int** columnSizes, int* returnSize) {
    int** B=(int **)malloc(sizeof(int *)*AColSizes[0]);
    for (int i=0; i<AColSizes[0]; i++) {
        B[i]=(int *)malloc(sizeof(int)*ARowSize);
        for (int j=0; j<ARowSize; j++) {
            B[i][j] = A[j][i];
        }
    }
    *returnSize=AColSizes[0];
    for (int i=0; i<AColSizes[0]; i++) {
        columnSizes[i][0]=ARowSize;
    }
    return B;
}


int main(int argc, const char * argv[]) {
    int** A=(int **)malloc(sizeof(int *)*3);
    for (int i=0; i<3; i++) {
        A[i]=(int *)malloc(sizeof(int)*2);
    }
    int row=0;
    for (int i=1; i<6; i++) {
        if(i%3==0)
            row++;
        A[row][i%3]=i;
    }
    int ARowSize=3;
    int *AColSizes=(int *)malloc(sizeof(int)*2);
    AColSizes[0]=2;
    AColSizes[1]=2;
    int** columnSizes=(int **)malloc(sizeof(int *)*2);
    for (int i=0; i<2; i++) {
        columnSizes[i]=(int *)malloc(sizeof(int)*3);
    }
    int *returnSize=(int *)malloc(sizeof(int));
    int **B=transpose(A, ARowSize, AColSizes, columnSizes, returnSize);
    for (int i=0; i<2; i++) {
        for (int j=0; j<3; j++) {
            printf("%d",B[i][j]);
        }
        printf("\n");
    }
    
}
