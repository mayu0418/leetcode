package leetcode;

import java.util.HashMap;

public class Single_Number_2 {

	/*
	给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
	说明：
	你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
	示例 1:
	输入: [2,2,3,2]
	输出: 3
	示例 2:
	输入: [0,1,0,1,0,1,99]
	输出: 99
	*/
	
	public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
			if (map.get(i) == 3) {
				map.remove(i);
			}
		}
        Object[] intAry = map.keySet().toArray();
        return (int)intAry[0];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
