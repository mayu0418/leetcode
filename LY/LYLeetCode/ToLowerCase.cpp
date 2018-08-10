#include <iostream>
using namespace std;

char* toLowerCase(char* str) {
    int index = 0;
    while (str[index]) {
        if (str[index]>='A'&str[index]<='Z') {
            str[index]+=('a'-'A');
        }
        index++;
    }
    return str;
}

int main(int argc, const char * argv[]) {
    char str[100];
    while (cin>>str) {
        cout<<toLowerCase(str);
    }
    return 0;
}
