package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Partition_Labels {

	/*
	字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
	示例 1:
	输入: S = "ababcbacadefegdehijhklij"
	输出: [9,7,8]
	解释:
	划分结果为 "ababcbaca", "defegde", "hijhklij"。
	每个字母最多出现在一个片段中。
	像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
	注意:
	S的长度在[1, 500]之间。
	S只包含小写字母'a'到'z'。
	*/
	
	public List<Integer> partitionLabels(String S) {
		List<Integer> list = new ArrayList<Integer>();
		if (S == null || S.length() < 1) {
			return list;
		}
        char[] cAry = S.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < cAry.length; i++) {
			map.put(cAry[i], i);
		}
        int start = 0;
        int end  = 0;
        for (int i = 0; i < cAry.length; i++) {
        	end = Math.max(end, map.get(cAry[i]));
			if (end == i) {
				list.add(end - start + 1);
				start = i + 1;
			}
		}
        return list;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
