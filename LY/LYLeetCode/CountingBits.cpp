//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
/*输入: 5
 输出: [0,1,1,2,1,2]
 输入: 2
 输出: [0,1,1]
 */
#include <iostream>
#include <stdio.h>

int* countBits(int num, int* returnSize) {
    int *coutsArray=(int *)malloc(sizeof(int)* (num+1));
    for(int i=0; i<=num; i++) {
        int count = 0;
        int tempNum=i;
        while (tempNum) {
            if (tempNum&1) {
                count++;
            }
            tempNum>>=1;
        }
        coutsArray[i]=count;
    }
    * returnSize=num+1;
    return coutsArray;
}

int main(int argc, const char * argv[]) {
    int returnSize = 0;
    int *coutsArray = countBits(2,&returnSize);
    for (int i=0; i<returnSize; i++) {
        printf("%d",coutsArray[i]);
    }
    return 0;
}
