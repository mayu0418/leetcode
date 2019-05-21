package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */
public class GroupAnagrams {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
//        Map<String, List<String>> map = new HashMap<String, List<String>>();
//        for (String s : strs) {
//            char[] ca = s.toCharArray();
//            Arrays.sort(ca);
//            String keyStr = String.valueOf(ca);
//            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
//            map.get(keyStr).add(s);
//        }
//        return new ArrayList<List<String>>(map.values());
//    }
}
