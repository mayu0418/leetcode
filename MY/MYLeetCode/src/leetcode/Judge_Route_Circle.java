package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Judge_Route_Circle {

/*	
	初始位置 (0, 0) 处有一个机器人。给出它的一系列动作，判断这个机器人的移动路线是否形成一个圆圈，换言之就是判断它是否会移回到原来的位置。
	移动顺序由一个字符串表示。
	每一个动作都是由一个字符来表示的。
	机器人有效的动作有 R（右），L（左），U（上）和 D（下）。
	输出应为 true 或 false，表示机器人移动路线是否成圈。
	示例 1:
	输入: "UD"
	输出: true
	示例 2:
	输入: "LL"
	输出: false
*/
	
	public static boolean judgeCircle(String moves) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character c : moves.toCharArray()) {
			if (c == 'L' || c == 'U') {
				if (!map.containsKey(c)) {
					map.put(c, 1);
				} else {
					map.put(c, map.get(c) + 1);
				}
			} else if (c == 'R') {
				if (!map.containsKey('L')) {
					map.put('L', -1);
				} else {
					map.put('L', map.get('L') - 1);
				}
			} else {
				if (!map.containsKey('U')) {
					map.put('U', -1);
				} else {
					map.put('U', map.get('U') - 1);
				}
			}
		}
        for (Integer i : map.values()) {
			if (i != 0) {
				return false;
			}
		}
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Judge_Route_Circle.judgeCircle("UD"));
	}

}
