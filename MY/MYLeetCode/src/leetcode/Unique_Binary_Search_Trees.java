package leetcode;

public class Unique_Binary_Search_Trees {

    //给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种
    public int numTrees(int n) {
        int [] dp = new int[n+1];
        dp[0]= 1;
        dp[1] = 1;
        for(int level = 2; level <=n; level++)
            for(int root = 1; root<=level; root++)
                dp[level] += dp[level-root]*dp[root-1];
        return dp[n];
    }

}
