/*
 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 
 找到所有出现两次的元素。
 
 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 输入:
 [4,3,2,7,8,2,3,1]
 
 输出:
 [2,3]
 */

#include <iostream>
#include<stdlib.h>

int* findDuplicates(int* nums, int numsSize, int* returnSize) {
    int *result=(int *)malloc(sizeof(int));
    *returnSize=0;
    for (int i=0;i<numsSize;i++) {
        nums[abs(nums[i])-1]=-nums[abs(nums[i])-1];
        if (nums[abs(nums[i])-1]>0) {
            result[*returnSize]=abs(nums[i]);
            (*returnSize)++;
            result=(int *)realloc(result, (*returnSize)+1);
        }
    }
    return result;
}

int main(int argc, const char * argv[]) {
    int array[]={13,8,5,3,20,12,3,20,5,16,9,19,12,11,13,19,11,1,10,2};
    int numsSize=20;
    int *nums=(int *)malloc(sizeof(int)*20);
    for (int i=0; i<numsSize; i++) {
        nums[i]=array[i];
    }
    int* returnSize=(int *)malloc(sizeof(int));
    findDuplicates(nums, numsSize, returnSize);
    return 0;
}
