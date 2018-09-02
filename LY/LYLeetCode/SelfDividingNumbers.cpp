/*
 自除数 是指可以被它包含的每一位数除尽的数。
 
 例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 
 还有，自除数不允许包含 0 。
 
 给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。
 
 输入：
 上边界left = 1, 下边界right = 22
 输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */

#include <iostream>

int* selfDividingNumbers(int left, int right, int* returnSize) {
    int *retunArray=(int*)malloc(sizeof(int)*200);
    if(!left) left++;
    for (int i=left; i<=right; i++) {
        int num=i;
        int dividing=num;
        bool canSelfDividing=true;
        while (dividing) {
            if (!(dividing%10)) {
                canSelfDividing=false;
                break;
            } else if (num%(dividing%10)) {
                canSelfDividing=false;
                break;
            }
            dividing/=10;
        }
        if (canSelfDividing) {
            retunArray[*returnSize]=num;
            (*returnSize)++;
        }
    }
    return retunArray;
}

int main(int argc, const char * argv[]) {
    int left=0;
    int right=128;
    int *returnSize=(int*)malloc(sizeof(int));
    int *returnArray=selfDividingNumbers(left, right, returnSize);
    for (int i=0; i<*returnSize; i++) {
        printf("%d\n",returnArray[i]);
    }
}
