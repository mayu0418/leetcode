package leetcode;

public class toLowerCase {
/*	709. To Lower Case
	Implement function ToLowerCase() that has a string parameter str, 
	and returns the same string in lowercase.
	Example 1:
		Input: "Hello"
		Output: "hello"
	Example 2:
		Input: "here"
		Output: "here"
	Example 3:
		Input: "LOVELY"
		Output: "lovely"*/
	public String toLowerCase(String str) {
		str = str.toLowerCase();
		return str;
    }
	public static String toLowerCase1(String str) {
		str = str.toLowerCase();
		char[] charAry = str.toCharArray();
		for (int i = 0; i < charAry.length; i++) {
			char c = charAry[i];
			if (i >= 'A' && i <= 'Z') {
				charAry[i] = (char) (c + 'a' - 'A');
			}
		}
		String string = "";
		for (char c : charAry) {
			string += c;
		}
		return string;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(toLowerCase.toLowerCase1("Mymommaalwayssaid,\"Lifewaslikeaboxofchocolates.Youneverknowwhatyou'regonnaget."));
	}

}
