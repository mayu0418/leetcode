package leetcode;

import java.util.ArrayList;

public class Jewels_and_Stones {
	
	/*You're given strings J representing the types of stones that are jewels, 
	and S representing the stones you have.
	Each character in S is a type of stone you have.
	You want to know how many of the stones you have are also jewels.
	The letters in J are guaranteed distinct, and all characters in J and S are letters.
	Letters are case sensitive, so "a" is considered a different type of stone from "A".
	Input: J = "aA", S = "aAAbbbb"
	Output: 3
	*/
	
	public static int numJewelsInStones(String J, String S) {
		ArrayList<Character> aryList = new ArrayList<Character>();
		for (Character character : J.toCharArray()) {
			aryList.add(character);
		}
		int count = 0;
		for (char c : S.toCharArray()) {
			if (aryList.contains(c)) {
				count++;
			}
		}
		return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String J = "aA";
		String S = "aAAbbbb";
		int count = Jewels_and_Stones.numJewelsInStones(J, S);
		System.out.println(count);
	}

}
