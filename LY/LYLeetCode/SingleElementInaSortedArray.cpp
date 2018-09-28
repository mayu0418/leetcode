//
//  main.cpp
//  SingleElementInaSortedArray
//
//  Created by Yi Li on 2018/9/28.
//  Copyright © 2018年 Yi Li. All rights reserved.
//

#include <iostream>
int singleNonDuplicate(int* nums, int numsSize) {
    int index=0;
    int result=-1;
    while (index<numsSize-1) {
        if (nums[index] == nums[index+1]) {
            index+=2;
        } else {
            result=nums[index];
            break;
        }
    }
    if (index == numsSize-1) {
        result=nums[numsSize-1];
    }
    return result;
}

int main(int argc, const char * argv[]) {
    int a[]={1,1,2,2,3,3,4,4,5};
    int *nums=a;
    int result=singleNonDuplicate(nums,9);
}
