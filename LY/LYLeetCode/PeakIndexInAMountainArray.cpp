/*我们把符合下列属性的数组 A 称作山脉：

A.length >= 3
存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 */
#include "iostream"
int peakIndexInMountainArray(int* A, int ASize) {
    for (int i=0; i<ASize-1; i++) {
        if (A[i]>A[i+1]) {
            return i;
        }
    }
    return 0;
}
int main() {
    int b[]={0,1,2,1,3};
    int *a=(int *)malloc(sizeof(int)*5);
    for (int i=0; i<5; i++) {
        a[i]=b[i];
    }
    peakIndexInMountainArray(a, 5);
}
