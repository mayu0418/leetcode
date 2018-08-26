class Solution {
     public  String[] findWords(String[] words) {
        List<Character> top =  Arrays.asList('q','w','e','r','t','y','u','i','o','p');
        List<Character> mid = Arrays.asList('a','s','d','f','g','h','j','k','l');
        List<Character> bottom = Arrays.asList('z','x','c','v','b','n','m');
        List<String> strings = new ArrayList<>();
        for (int i=0;i<words.length;i++){
            String temp = words[i].toLowerCase();
            if (check(temp,bottom)||check(temp,mid)||check(temp,top)){
                strings.add(words[i]);
            }
        }
        String[] s = new String[strings.size()];
        return  strings.toArray(s);
    }

    private  boolean check(String word,List<Character> list){
        char[] c = word.toCharArray();
        for (int i=0;i<c.length;i++){
            if (!list.contains(c[i])) return false;
        }
        return true;
    }
}
