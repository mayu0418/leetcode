/*
 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 
 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 
 （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 
 返回 words 中与给定模式匹配的单词列表。
 
 你可以按任何顺序返回答案。
 
 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 输出：["mee","aqq"]
 解释：
 "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 因为 a 和 b 映射到同一个字母。
 */
#include <iostream>
using namespace std;

char** findAndReplacePattern(char** words, int wordsSize, char* pattern, int* returnSize) {
    int wordSize=strlen(pattern);
    char **returnWords=(char **)malloc(sizeof(char*)*wordsSize);
    int count=0;
    for (int i=0; i<wordsSize; i++) {
        bool canAdd=true;
        char *tempword=(char *)malloc(sizeof(char)*wordSize);
        for (int j=0; j<wordSize; j++) {
            for (int k=0; k<j; k++) {
                if (tempword[k]==pattern[j]) {
                    if (words[i][j]!=words[i][k]) {
                        canAdd=false;
                        break;
                    }
                } else {
                    if (words[i][j]==words[i][k]) {
                        canAdd=false;
                        break;
                    }
                }
                tempword[j]=pattern[j];
            }
        }
        if (canAdd) {
            returnWords[count]=(char *)malloc(sizeof(char)*wordSize);
            for (int j=0; j<wordSize; j++) {
                returnWords[count][j]=words[i][j];
            }
            count++;
        }
    }
    *returnSize=count;
    return returnWords;
}

int main(int argc, const char * argv[]) {
    char a[6][3]={{'a','b','c'},{'d','e','f'},{'m','e','e'},{'a','q','q'},{'d','k','d'},{'c','c','c'}};
    //char a[3][1]={{'a'},{'b'},{'c'}};
    char **words =(char **)malloc(sizeof(char*) * 6);
    for(int i=0;i<3;i++ )
        words[i]=(char *)malloc(sizeof(char));
    for (int i=0; i<3; i++) {
        for (int j=0; j<1; j++) {
            words[i][j]=a[i][j];
        }
    }
    int wordSize = 3;
    char *pattern="a";
    int *returnSize = new(int);
    char **retunWords=findAndReplacePattern(words, wordSize, pattern, returnSize);
    for (int i=0; i<*returnSize; i++) {
        for (int j=0; j<5; j++) {
            printf("%c",retunWords[i][j]);
        }
        printf("\n");
    }
}
