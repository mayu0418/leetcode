/*
 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 输入: "Let's take LeetCode contest"
 输出: "s'teL ekat edoCteeL tsetnoc"
 */
#include <iostream>
#include "string.h"

void reverseWord(int start,int end, char *s) {
    int reverseLength=end-start+1;
    int harfLength=reverseLength/2;
    for (int i=start,count=0; i<start+harfLength; i++,count++) {
        int tempNum=s[end-count];
        s[end-count]=s[i];
        s[i]=tempNum;
    }
}

char* reverseWords(char* s) {
    int length=strlen(s);
    
    int start=0;
    int end=0;
    for (int i=0; i<length; i++) {
        if (s[i]==' ') {
            end=i-1;
            reverseWord(start,end,s);
            start=i+1;
            end=start;
        }
    }
    reverseWord(start,length-1,s);
    return s;
}


int main(int argc, const char * argv[]) {
    char *a=(char *)malloc(sizeof(char)*100);
    char *returnWord;
    puts(a);
    char b[10]={'a','b','c',' ','a','m',' ','g','o','o'};
    for (int i=0; i<10; i++) {
        a[i]=b[i];
    }
    returnWord=reverseWords(a);
}
