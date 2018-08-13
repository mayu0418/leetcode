#include <iostream>
#include <string.h>
using namespace std;

int uniqueMorseRepresentations(char** words, int wordsSize) {
    string code[]={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    int size1 = wordsSize;
    string afterStr[]={};
    for (int i=0; i<wordsSize; i++) {
        int wordLength = strlen(words[i]);
        afterStr[i]={};
        for (int j=0; j<strlen(words[i]); j++) {
            afterStr[i]+=code[(int)(words[i][j]-'a')];
        }
    }
    int count=0;
    for (int i=0; i<wordsSize; i++) {
         for (int j=i+1; j<wordsSize; j++)
         {
             if (afterStr[i].compare(afterStr[j])==0) {
                 count++;
             }
         }
    }

    return wordsSize-count;
}

int main(int argc, const char * argv[]) {
    char **words = new char*;
    words[0] = "gin";
    words[1] = "zen";
    words[2] = "gig";
    words[3] = "msg";
    cout<<uniqueMorseRepresentations(words,4);
    return 0;
}
