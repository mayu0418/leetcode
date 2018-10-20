/*寻找重复数
 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 输入: [1,3,4,2,2]
 输出: 2
 输入: [3,1,3,4,2]
 输出: 3
 */

#include <iostream>

int findDuplicate(int* nums, int numsSize) {
    int result=0;
    for (int i=0;i<numsSize;i++) {
        nums[abs(nums[i])-1]=-nums[abs(nums[i])-1];
        if (nums[abs(nums[i])-1]>0) {
            result=abs(nums[i]);
            break;
        }
    }
    return result;
}

int main(int argc, const char * argv[]) {
    int array[]={1,3,4,2,2};
    int numsSize=5;
    int *nums=(int *)malloc(sizeof(int)*20);
    for (int i=0; i<numsSize; i++) {
        nums[i]=array[i];
    }
    int a=findDuplicate(nums, numsSize);
    return 0;
}
