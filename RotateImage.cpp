/*
 给定一个 n × n 的二维矩阵表示一个图像。
 
 将图像顺时针旋转 90 度。
 给定 matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],
 
 原地旋转输入矩阵，使其变为:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 */

#include <iostream>
void rotate(int** matrix, int matrixRowSize, int *matrixColSizes) {
    for (int i=0; i<matrixRowSize; i++) {
        for (int j=i+1; j<matrixRowSize; j++) {
            int temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
        }
    }
    for (int i=0; i<matrixRowSize; i++) {
        for (int j=0; j<matrixRowSize/2; j++) {
            int temp=matrix[i][j];
            matrix[i][j]=matrix[i][matrixRowSize-1-j];
            matrix[i][matrixRowSize-1-j]=temp;
        }
    }
    for (int i=0; i<matrixRowSize; i++) {
        matrixColSizes[i]=matrixRowSize;
    }
}


int main(int argc, const char * argv[]) {
    int **matrix = (int **)malloc(sizeof(int*)*3);
    int num=1;
    for (int i=0; i<3; i++) {
        matrix[i] = (int *)malloc(sizeof(int));
        for (int j=0; j<3; j++) {
            matrix[i][j] = num++;
        }
    }
    int *matrixColSizes =(int *)malloc(sizeof(int)*3);
    rotate(matrix, 3, matrixColSizes);
    return 0;
}

