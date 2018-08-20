/*
 初始位置 (0, 0) 处有一个机器人。给出它的一系列动作，判断这个机器人的移动路线是否形成一个圆圈，换言之就是判断它是否会移回到原来的位置。
 
 移动顺序由一个字符串表示。每一个动作都是由一个字符来表示的。机器人有效的动作有 R（右），L（左），U（上）和 D（下）。输出应为 true 或 false，表示机器人移动路线是否成圈。
 */
#include <iostream>
#include "string.h"

bool judgeCircle(char* moves) {
    int length = strlen(moves);
    int x=0,y=0;
    for (int i=0; i<length; i++) {
        if (moves[i] == 'L') {
            x--;
        } else if (moves[i] == 'R') {
            x++;
        } else if (moves[i] == 'U') {
            y--;
        } else if (moves[i] == 'D') {
            y++;
        }
    }
    if (x==0&&y==0) {
        return true;
    } else {
        return false;
    }
}

int main(int argc, const char * argv[]) {
    char a[]={'L','R','U','D'};
    char *moves=(char *)malloc(sizeof(char)*4);
    for (int i=0; i<4; i++) {
        moves[i]=a[i];
    }
    judgeCircle(moves);
    
}


