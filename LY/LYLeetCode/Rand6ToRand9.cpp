/*
 已有0~6的随机数生函数，定义一0~9的随机数函数
*/
#include <iostream>
#include <stdlib.h>
#include <stdio.h>

int rand6() {
    return rand()%7;
}

int rand9() {
    int a;
    do {
        a=rand6()*7+rand6();
    } while (a>=40);
    return a%10;
}

int main(int argc, const char * argv[]) {
    
    int a = rand6();
    int b = rand6();
    int c = rand6();
    int d = rand6();
    int e = rand6();
    printf("%d\n",rand9());
    return 0;
}
