package leetcode;

        /*
        给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
        示例:
        输入: n = 4, k = 2
        输出:
        [
        [2,4],
        [3,4],
        [2,3],
        [1,2],
        [1,3],
        [1,4],
        ]
        */

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List lists = new ArrayList();
        test(n, k, 1, lists, new ArrayList());
        return  lists;
    }
    
    void test(int n,int k,int cur, List list, ArrayList aryList) {
        if (aryList.size() == k ) {
            list.add(new ArrayList<Integer>(aryList));
        } else if (cur <= n) {
            for (int i = cur; i <= n; i++) {
                aryList.add(i);
                test(n, k, i + 1, list, aryList);
                aryList.remove(aryList.size() - 1);
            }
        }
    }
    
}
