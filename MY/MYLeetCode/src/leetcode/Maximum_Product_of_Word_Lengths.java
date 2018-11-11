package leetcode;

public class Maximum_Product_of_Word_Lengths {

    /*
    给定一个字符串数组 words，
    找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
    你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
    输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
    输出: 16
    解释: 这两个单词为 "abcw", "xtfn"。
    */

    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isValid(words[i],words[j])) {
                    max = Math.max(words[i].length() * words[j].length(),max);
                }
            }
        }
        return max;
    }

    Boolean isValid(String s1, String s2) {
        for (Character c : s1.toCharArray()) {
            String s = "" + c;
            if (s2.contains(s)) return false;
        }
        return true;
    }
}
