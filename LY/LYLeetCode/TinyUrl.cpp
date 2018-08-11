#include <iostream>
#import<string.h>
using namespace std;
char strKey[100];
char* encode(char* longUrl) {
    char *shortUrl = (char *)malloc(sizeof(char)*100);
    unsigned long length=strlen(longUrl);
    unsigned long dealLength=length/2;
    strncpy(shortUrl, longUrl, length-dealLength);
    strncpy(strKey, longUrl+(length-dealLength), dealLength);
    return shortUrl;
}

/** Decodes a shortened URL to its original URL. */
char* decode(char* shortUrl) {
    strcat(shortUrl, strKey);
    return shortUrl;
}

int main(int argc, const char * argv[]) {
    char *longUrl=(char *)malloc(sizeof(char)*100);
    while (cin>>longUrl) {
        char *tinyUrl=encode(longUrl);
        cout<<decode(tinyUrl);
    }
}
