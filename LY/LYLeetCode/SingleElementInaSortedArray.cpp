//
//  main.cpp
//  SingleElementInaSortedArray
//
//  Created by Yi Li on 2018/9/28.
//  Copyright © 2018年 Yi Li. All rights reserved.
//

#include <iostream>
int singleNonDuplicate(int* nums, int numsSize) {
    int start=0;
    int end=numsSize-1;
    while (start<end) {
        int mid=(start+end)/2;
        if (mid+1<numsSize&&nums[mid]==nums[mid+1]) {
            if (mid%2==0) {
                start+=2;
            } else {
                end-=1;
            }
        } else if(mid-1>=0&&nums[mid]==nums[mid-1]) {
            if (mid%2==0) {
                end-=1;
            } else {
                start+=2;
            }
        } else {
            return nums[mid];
        }
    } return nums[start];
}

int main(int argc, const char * argv[]) {
    int a[]={1,1,2,2,3,3,4,4,5};
    int *nums=a;
    int result=singleNonDuplicate(nums,9);
}
