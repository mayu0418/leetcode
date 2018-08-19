/*两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 输入: x = 1, y = 4
 
 输出: 2
 
 解释:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 */
 #include <iostream>

int hammingDistance(int x, int y) {
    int diff = x^y;
    int count=0;
    while (diff) {
        if (diff&1) {
            count++;
        }
        diff>>=1;
    }
    return count;
}

int main(int argc, const char * argv[]) {
    printf("%d",hammingDistance(1, 4));
}
