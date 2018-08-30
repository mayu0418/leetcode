package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Find_and_Replace_Pattern {

	/*
	你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
	如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
	（回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
	返回 words 中与给定模式匹配的单词列表。
	你可以按任何顺序返回答案。
	示例：
	输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
	输出：["mee","aqq"]
	解释：
	"mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
	"ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
	因为 a 和 b 映射到同一个字母。
	提示：
	1 <= words.length <= 50
	1 <= pattern.length = words[i].length <= 20
	*/
	public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<String>();
        if (pattern.length() == 0) {
			return list;
		}
        
        
        for (String s : words) {
			if (isEqual(pattern, s)) {
				list.add(s);
			}
		}
        
        return list;
    }
	
	static Boolean isEqual(String s,String s1) {
		ArrayList<Integer> patternList = getIdxList(s);
		ArrayList<Integer> curList = getIdxList(s1);
        if (patternList.size() != curList.size()) {
			return false;
		}
        for (int i = 0; i < patternList.size(); i++) {
			if (patternList.get(i) != curList.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	static ArrayList<Integer> getIdxList(String s) {
		ArrayList<Integer> patternList = new ArrayList<Integer>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] cAry = s.toCharArray();
        for (int i = 0; i < cAry.length; i++) {
        	if (!map.containsKey(cAry[i])) {
        		map.put(cAry[i], i);
			}
        	patternList.add(map.get(cAry[i]));
		}
        return patternList;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] ary = {"abc","deq","mee","aqq","dkd","ccc"};
		System.out.println(Find_and_Replace_Pattern.findAndReplacePattern(ary,"abb"));
	}

}
