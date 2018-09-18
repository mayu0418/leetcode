/*
 一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
 
 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com"。
 
 接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
 
 示例 2
 输入:
 ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
 输出:
 ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
 说明:
 按照假设，会访问"google.mail.com" 900次，"yahoo.com" 50次，"intel.mail.com" 1次，"wiki.org" 5次。
 而对于父域名，会访问"mail.com" 900+1 = 901次，"com" 900 + 50 + 1 = 951次，和 "org" 5 次。
 */

#include "iostream"
#include "string.h"
#include <stdlib.h>
#include <stdio.h>
using namespace std;


//字符串倒转
void string_change(char * p)
{
    int i,len;
    char temp;
    len = strlen(p);
    
    //printf("%d \n", len);
    //test printf("%d\n",len);
    
    for(i=0; i<(len/2); i++)
    {
        temp = p[i];
        p[i] = p[len-1-i];
        p[len-1-i] = temp;
    }
}

char** subdomainVisits(char** cpdomains, int cpdomainsSize, int* returnSize) {
    //存储每个串初始值
    int count[cpdomainsSize];
    //以下两个值一一对应
    int *requestCount = (int *)malloc(sizeof(int)*1000);
    char **returnArray=(char **)malloc(sizeof(char *)*1000);
    //最后返回的条数
    int resultCount=0;
    for (int i=0; i<100; i++) {
        requestCount[i]=0;
    }
    for (int i=0; i<cpdomainsSize; i++) {
        int j=0;
        int num=0;
        while (cpdomains[i][j]!=' ') {
            num=num*10+(cpdomains[i][j]-'0');
            j++;
        }
        count[i]=num;
        char *a=(char *)malloc(sizeof(char)*1000);
        int stringLength=strlen(cpdomains[i]);
        
        strncpy(a, cpdomains[i]+j+1, stringLength-j-1);
        bool canatch = false;
        for (int k=0; k<resultCount; k++) {
            if (strcmp(returnArray[k], a) == 0) {
                requestCount[k]+=count[i];
                canatch=true;
            }
        }
        if (!canatch) {
            requestCount[i]=count[i];
            returnArray[resultCount]=a;
            resultCount++;
        }
        
        while (j<stringLength) {
            if (cpdomains[i][j]=='.') {
                a=(char *)malloc(sizeof(char)*stringLength-j-1);
                strncpy(a, cpdomains[i]+j+1, stringLength-j-1);
                bool canatch = false;
                for (int k=0; k<resultCount; k++) {
                    if (strcmp(returnArray[k], a) == 0) {
                        requestCount[k]+=count[i];
                        canatch=true;
                    }
                }
                if (!canatch) {
                    requestCount[i]=count[i];
                    returnArray[resultCount]=a;
                    resultCount++;
                }
            }
            j++;
        }
    }
    char **finalReturnArray=(char **)malloc(sizeof(char *)*1000);
    for (int i=0; i<resultCount; i++) {
        int tempNum=requestCount[i];
        char *resultStr=(char *)malloc(sizeof(char)*1000);
        int tempCount=0;
        while (tempNum) {
            resultStr[tempCount]=tempNum%10+'0';
            tempNum/=10;
            tempCount++;
        }
        string_change(resultStr);
        strcat(resultStr, " ");
        strcat(resultStr, returnArray[i]);
        finalReturnArray[i]=resultStr;
    }
    *returnSize=resultCount;
    return finalReturnArray;
}


int main(int argc, const char * argv[]) {
    
    char **cpdomains = (char **)malloc(sizeof(char *)*4);
    cpdomains[0] = "900 google.mail.com";
    cpdomains[1] = "50 yahoo.com";
    cpdomains[2] = "1 intel.mail.com";
    cpdomains[3] = "5 wiki.org";
    int cpdomainsSize = 4;
    int* returnSize=(int *)malloc(sizeof(int));
    char** result=subdomainVisits(cpdomains, cpdomainsSize, returnSize);
    
}
