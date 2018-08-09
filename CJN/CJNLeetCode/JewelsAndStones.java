 class Solution {
        public int numJewelsInStones(String J, String S) {
            if (J == null || S == null || J.length() == 0 || S.length() == 0) return 0;
            int target = 0;
            char[] cJ = J.toCharArray();
            char[] cS = S.toCharArray();
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            for (int i = 0; i < cS.length; i++) {
                if (map.containsKey(cS[i])) {
                    map.put(cS[i], map.get(cS[i]) + 1);
                } else {
                    map.put(cS[i], 1);
                }
            }
            for (int j = 0; j < cJ.length; j++) {
                if (map.containsKey(cJ[j])) target = target + map.get(cJ[j]);
            }
            return target;
        }
    }
