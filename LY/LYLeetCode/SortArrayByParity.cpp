/*
 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 
 你可以返回满足此条件的任何数组作为答案。
 输入：[3,1,2,4]
 输出：[2,4,3,1]
 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */

#include <iostream>

int* sortArrayByParity(int* A, int ASize, int* returnSize) {
    int i=0,j=ASize-1;
    while (i<j) {
        //对前面的奇数进行操作
        if (A[i]%2==1) {
            //从后往前找到偶数
            while (A[j]%2 != 0 && i<j) {
                j--;
            }
            if (A[j]%2 == 0) {
                //交换奇数和偶数
                int temp=A[i];
                A[i]=A[j];
                A[j]=temp;
            }
        }
        i++;
    }
    *returnSize = ASize;
    return A;
}

int main(int argc, const char * argv[]) {
    int ASize = 4;
    int *A=(int *)malloc(sizeof(int)*ASize);
    A[0]=3;A[1]=1;A[2]=2;A[3]=4;
    
    int* returnSize=(int *)malloc(sizeof(int));
    int* B=sortArrayByParity(A,ASize,returnSize);
    for (int i=0; i<4; i++) {
        printf("%d\n",B[i]);
    }
}
