/*
 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 输入: S = "ababcbacadefegdehijhklij"
 输出: [9,7,8]
 解释:
 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 每个字母最多出现在一个片段中。
 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */

#include <iostream>

int* partitionLabels(char* S, int* returnSize) {
    int*returnPart=(int *)malloc(sizeof(int));
    int length=strlen(S);
    int start=0,end=length-1,current=0,count=0,currentBiggest=0;
    while (current<=length-1) {
        while (end>current&&current<length-1) {
            for (int j=length-1; j>=start; j--) {
                if (S[current]==S[j]&&j>=currentBiggest) {
                    end=j;
                    currentBiggest=end;
                    break;
                }
            }
            current++;
        }
        returnPart = (int *)realloc(returnPart, (count+1)*sizeof(int));
        returnPart[count++]=end-start+1;
        start=end+1;
        end=length-1;
        current=start;
        currentBiggest=start;
        (* returnSize)++;
    }
    return returnPart;
}

int main(int argc, const char * argv[]) {
    char *S="eaaaabaaec";
    int *returnSize=(int *)malloc(sizeof(int)*10);
    partitionLabels(S,returnSize);
    return 0;
}
