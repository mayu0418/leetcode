package leetcode;

import java.util.List;

public class Triangle {

    /*
    给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
    例如，给定三角形：

            [
            [2],
            [3,4],
            [6,5,7],
            [4,1,8,3]
            ]
    自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
    */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}
