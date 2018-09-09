/*
 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 输入: 38
 输出: 2
 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 */

#include <iostream>

int addDigits(int num) {
    int returnNum = num;
    while (returnNum>9) {
        int afterAdd = returnNum;
        returnNum=0;
        while (afterAdd) {
            returnNum+=afterAdd%10;
           afterAdd /=10;
        }
    }
    return returnNum;
}

int main(int argc, const char * argv[]) {
    int a=addDigits(38);
    return 0;
}
