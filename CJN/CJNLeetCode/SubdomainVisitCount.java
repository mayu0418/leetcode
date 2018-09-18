class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
         Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            int j = cpdomains[i].indexOf(' ');
            int n = Integer.valueOf(cpdomains[i].substring(0, j));
            String s = cpdomains[i].substring(j + 1);
            for (j = 0; j < s.length(); ++j) {
                if (s.charAt(j) == '.') {
                    String d = s.substring(j + 1);
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
            map.put(s, map.getOrDefault(s, 0) + n);
        }
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) result.add(map.get(key) + " " + key);
        return result;
    }
}
