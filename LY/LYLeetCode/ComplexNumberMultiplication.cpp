/*
 给定两个表示复数的字符串。
 
 返回表示它们乘积的字符串。注意，根据定义 i2 = -1 。
 输入: "1+1i", "1+1i"
 输出: "0+2i"
 解释: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 
 输入: "1+-1i", "1+-1i"
 输出: "0+-2i"
 解释: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。 
 */

#include <iostream>
#include "string.h"
#include "stdlib.h"

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


char* complexNumberMultiply(char* a, char* b) {
    int lengthA=strlen(a);
    int lengthB=strlen(b);
    int frontANum,behindANum,frontBNum,behindBNum;
    for (int i=0; i<lengthA; i++) {
        if (a[i] == '+') {
            char*frontStr=(char *)malloc(sizeof(char)*i);
            strncpy(frontStr, a, i);
            frontANum=atoi(frontStr);
            
            char*behindStr=(char *)malloc(sizeof(char)*(lengthA-i-1));
            strncpy(behindStr, a+i+1, lengthA-i-1);
            if (strcmp(behindStr, "i")==0) {
                behindStr="1";
            }
            behindANum=atoi(behindStr);
        }
    }
    
    for (int i=0; i<lengthB; i++) {
        if (b[i] == '+') {
            char*frontStr=(char *)malloc(sizeof(char)*i);
            strncpy(frontStr, b, i);
            frontBNum=atoi(frontStr);

            char*behindStr=(char *)malloc(sizeof(char)*(lengthA-i-1));
            strncpy(behindStr, b+i+1, lengthA-i-1);
            if (strcmp(behindStr, "i")==0) {
                behindStr="1";
            }
            behindBNum=atoi(behindStr);
        }
    }
    int integer=frontANum*frontBNum-behindANum*behindBNum;
    int complex=frontANum*behindBNum+frontBNum*behindANum;
    char *integerStr=(char *)malloc(sizeof(char)*100);
    char *complexStr=(char *)malloc(sizeof(char));
    int length=0;
    if (!integer) {
        integerStr[0]='0';
    }
    while (integer) {
        integerStr[length-1]=integer%10+'0';
        integer=integer/10;
    }
    length=0;
    while (complex) {
        realloc(complexStr, ++length);
        complexStr[length-1]=complex%10+'0';
        complex=complex/10;
    }
    string_change(integerStr);
    string_change(complexStr);
    strcat(integerStr,"+");
    strcat(integerStr, complexStr);
    strcat(integerStr, "i");
    return integerStr;
}

int main(int argc, const char * argv[]) {
    char *a="1+i";
    char *b="1+i";
    char *result=complexNumberMultiply(a,b);
    printf("%s",result);
}
