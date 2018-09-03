class Solution {
    public List<Integer> partitionLabels(String S) {
          List<Integer> list = new ArrayList<>();
        if (S==null||S.length()==0) return list;
        int n = S.length(), start = 0, last = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = S.toCharArray();
        for (int i = 0; i < n; ++i) map.put(c[i], i);
        for (int i = 0; i < n; ++i) {
            last = Math.max(last, map.get(c[i]));
            if (i == last) {
                list.add(i - start + 1);
                start = i + 1;
            }
        }
        return list;
    }
}
