/*
 不同的二叉搜索树
 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 输入: 3
 输出: 5
 解释:
 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 
 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

 */

#include <iostream>

int numTrees(int n) {
    if (n==0||n==1) {
        return 1;
    }
    int sum=0;
    for (int i=1; i<=n; i++) {
        sum+=numTrees(i-1)*numTrees(n-i);
    }
    return sum;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    printf("%d",numTrees(3));
    return 0;
}
