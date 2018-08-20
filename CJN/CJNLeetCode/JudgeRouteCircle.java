class Solution {
    public boolean judgeCircle(String moves) {
              HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] chars = moves.toCharArray();
        for (int i=0;i<chars.length;i++){
            hashMap.put(chars[i],hashMap.getOrDefault(chars[i],0)+1);
        }
        return (hashMap.getOrDefault('U',0).equals(hashMap.getOrDefault('D',0)))&&(hashMap.getOrDefault('L',0).equals(hashMap.getOrDefault('R',0)));
    }
}
