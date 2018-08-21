/*
 Input: 3
 Output:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */

#include <iostream>

int** generateMatrix(int n) {
    int **matrix=(int **)malloc(sizeof(int*)*n);
    for (int i=0; i<n; i++) {
        matrix[i]=(int *)malloc(sizeof(int)*n);
    }
    int curretNum=1;
    //p记录本次要走的步数
    int p=n-1;
    for (int i=0; i<n/2; i++) {
        //int  count = p-1;
        for (int col=i; col<i+p; col++) {
            matrix[i][col]=curretNum++;
        }
        for (int row=i; row<i+p; row++) {
            matrix[row][i+p]=curretNum++;
        }
        for (int col=i+p; col>i; col--) {
            matrix[i+p][col]=curretNum++;
        }
        for (int row=i+p; row>i; row--) {
            matrix[row][i]=curretNum++;
        }
        p-=2;
    }
    if (n%2) {
        matrix[n/2][n/2]=curretNum;
    }
    return matrix;
}

int main(int argc, const char * argv[]) {
    int** result=generateMatrix(5);
    for (int i=0; i<5; i++) {
        for (int j=0; j<5; j++) {
            printf("%d ",result[i][j]);
        }
        printf("\n");
    }
}
