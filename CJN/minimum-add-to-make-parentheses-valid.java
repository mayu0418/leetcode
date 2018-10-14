class Solution {
    public int minAddToMakeValid(String S) {
 char[]  c = S.toCharArray();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<c.length;i++){
            if(!stack.isEmpty()&&stack.peek().equals(map.get(c[i]))){
                stack.pop();
            }else {
                stack.push(c[i]);
            }
        }
        return stack.size();
    }
}
