/*
 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 
 输入: "2-1-1"
 输出: [0, 2]
 解释:
 ((2-1)-1) = 0
 (2-(1-1)) = 2
 */

#include "stdlib.h"
#include <string.h>
#include <iostream>
using namespace std;


int* diffWaysToCompute(char* input, int* returnSize) {
    int *returnAtrray = (int *)malloc(sizeof(int)*100);
    int count = 0;
    int length=strlen(input);
    for (int i=0; i<length; i++) {
        if (input[i]=='+'||input[i]=='-'||input[i]=='*') {
            char *left=(char *)malloc(sizeof(char)*(i+1));
            for (int j=0; j<i; j++) {
                left[j]=input[j];
            }
            char *right=(char *)malloc(sizeof(char)*(length-i));
            for (int j=0; j<length-i; j++) {
                right[j]=input[i+j+1];
            }
            int *returnSize1=(int *)malloc(sizeof(int));
            int *returnSize2=(int *)malloc(sizeof(int));
            
            int*tempLeft=diffWaysToCompute(left,returnSize1);
            int*tempRight=diffWaysToCompute(right,returnSize2);
            for (int a=0; a<*returnSize1; a++) {
                for (int b=0; b<*returnSize2; b++) {
                    if (input[i]=='+') {
                        returnAtrray[count++]=tempLeft[a]+tempRight[b];
                    } else if (input[i]=='-') {
                        returnAtrray[count++]=tempLeft[a]-tempRight[b];
                    } else if (input[i]=='*') {
                        returnAtrray[count++]=tempLeft[a]*tempRight[b];
                    }
                }
            }
            
        }
    }
    if (count==0) {
        returnAtrray[count++]=atoi(input);
    }
    *returnSize = count;
    return returnAtrray;
}

int main(int argc, const char * argv[]) {
    char *input="2*3-4*5";
    int* returnSize=(int *)malloc(sizeof(int));
    int *haha=diffWaysToCompute(input, returnSize);
    for (int i=0; i<5; i++) {
        printf("%d\n",haha[i]);
    }
    return 0;
}
