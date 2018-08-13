class Solution {
    public int uniqueMorseRepresentations(String[] words) {
         String[] mors = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            map.put(c, mors[i]);
        }
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            StringBuilder morsWord = new StringBuilder();
            for (int j = 0; j < word.length; j++) {
                morsWord.append(map.get(word[j]));
            }
            set.add(morsWord.toString());
        }
        return set.size();
    }
}
