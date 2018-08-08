//
//  main.cpp
//  JewelsAndStones
//
//  Created by Yi Li on 2018/8/8.
//  Copyright © 2018年 Yi Li. All rights reserved.
//

#include <iostream>
using namespace std;

void countJewels(char *jewels,char *stones) {
    int count = 0;
    int i = 0;
    while (jewels[i]) {
        char a = jewels[i];
        int j = 0;
        while (stones[j]) {
            char b = stones[j];
            if (a == b) {
                count ++;
            }
            j++;
        }
        i++;
    }
    cout<<count<<endl;
}

int main(int argc, const char * argv[]) {
    char jewels[100];
    char stones[100];
    while (cin>>jewels) {
        cin>>stones;
        countJewels(jewels, stones);
    }
    return 0;
}


