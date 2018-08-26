package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Keyboard_Row {

	/*
	给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
	American keyboard
	示例1:
	输入: ['Hello', 'Alaska', 'Dad', 'Peace']
	输出: ['Alaska', 'Dad']
	注意:
	你可以重复使用键盘上同一字符。
	你可以假设输入的字符串将只包含字母。
	*/
	public static String[] findWords(String[] words) {
		ArrayList<String> aryList = new ArrayList<String>();
		if (words == null || words.length == 0) {
			String[] ary = new String[0];
			return ary;
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('q', 1);
		map.put('w', 1);
		map.put('e', 1);
		map.put('r', 1);
		map.put('t', 1);
		map.put('y', 1);
		map.put('u', 1);
		map.put('i', 1);
		map.put('o', 1);
		map.put('p', 1);
		
		map.put('a', 2);
		map.put('s', 2);
		map.put('d', 2);
		map.put('f', 2);
		map.put('g', 2);
		map.put('h', 2);
		map.put('j', 2);
		map.put('k', 2);
		map.put('l', 2);
		
		map.put('z', 3);
		map.put('x', 3);
		map.put('c', 3);
		map.put('v', 3);
		map.put('b', 3);
		map.put('n', 3);
		map.put('m', 3);
		
		
		for (String string : words) {
			String string1 = string.toLowerCase();
			char[] strAry = string1.toCharArray();
			Character s = strAry[0];
			int idx = map.get(s);
			Boolean isSame = true;
			for (char c : strAry) {
				if (map.get(c) != idx) {
					isSame = false;
					break;
				}
			}
			if (isSame) {
				aryList.add(string);
			}
			
		}
		String[] ary = (String[])aryList.toArray(new String[aryList.size()]);
		return ary;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] string = {};
		Keyboard_Row.findWords(string);
	}

}
