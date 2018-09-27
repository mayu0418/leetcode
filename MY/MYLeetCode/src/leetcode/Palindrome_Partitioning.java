package leetcode;

/*
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
        返回 s 所有可能的分割方案。
        示例:
        输入: "aab"
        输出:
        [
        ["aa","b"],
        ["a","a","b"]
        ]
*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List list = new ArrayList();
        if (s.equals("")) {
            list.add(new ArrayList<String>());
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (isHuiwen(s,i + 1)) {
                    for (List curList: partition(s.substring(i+1))) {
                        curList.add(0,s.substring(0,i+1));
                        list.add(curList);
                    }
                }
            }
        }
        return list;
    }

    Boolean isHuiwen(String s, int n) {
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        }
        return true;
    }
    
    Boolean isHuiwen(String s) {
        Queue queue = new LinkedList();
        char[] cAry = s.toCharArray();
        for (char c: cAry ) {
            queue.add(c);
        }
        for (Character c: cAry ) {
            if (c != queue.poll()) return  false;
        }
        return  true;
    }
}
