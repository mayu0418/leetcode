package leetcode;


import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_3 {

    /*
    找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
    说明：
    所有数字都是正整数。
    解集不能包含重复的组合。
    示例 1:
    输入: k = 3, n = 7
    输出: [[1,2,4]]
    示例 2:
    输入: k = 3, n = 9
    输出: [[1,2,6], [1,3,5], [2,3,4]]
    */

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        test(k,n,lists,new ArrayList<>(),1);
        return  lists;
    }

    static void test(int k,int target,List<List<Integer>> lists, ArrayList<Integer> aryList,int cur) {
        if (aryList.size() == k && target == 0) {
            lists.add(new ArrayList<>(aryList));
        } else if (target > 0 && cur <= 9){
            for (int i = cur; i <= 9; i++) {
                aryList.add(i);
                test(k,target - i,lists,aryList,i + 1);
                aryList.remove(aryList.size() - 1);
            }
        }
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        System.out.println(combinationSum3(3,7));
    }
}
