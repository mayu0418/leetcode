/*
 自定义字符串排序
 
 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 
 S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 
 返回任意一种符合条件的字符串T。
 
 示例:
 输入:
 S = "cba"
 T = "abcd"
 输出: "cbad"
 解释:
 S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a".
 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 */

#include <iostream>
#include "string.h"

char* customSortString(char* S, char* T) {
    size_t lengthS=strlen(S);
    size_t lengthT=strlen(T);
    int index=0;
    for (size_t i=0;i<lengthS;i++) {
        for (size_t j=index;j<lengthT;j++) {
            if (S[i]==T[j]) {
                int temp=T[j];
                T[j]=T[index];
                T[index]=temp;
                index++;
            }
        }
    }
    return T;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
