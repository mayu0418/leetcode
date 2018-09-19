package leetcode;

        /*
        一个网站域名，如"discuss.leetcode.com"，
        包含了多个子域名。
        作为顶级域名，常用的有"com"，
        下一级则有"leetcode.com"，最低的一级为"discuss.leetcode.com"。
        当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.com"以及顶级域名 "com"。
        给定一个带访问次数和域名的组合，
        要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，
        例如："9001 discuss.leetcode.com"。
        接下来会给出一组访问次数和域名组合的列表cpdomains 。
        要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。
        示例 1:
        输入:
        ["9001 discuss.leetcode.com"]
        输出:
        ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
        说明:
        例子中仅包含一个网站域名："discuss.leetcode.com"。按照前文假设，子域名"leetcode.com"和"com"都会被访问，所以它们都被访问了9001次。
        示例 2
        输入:
        ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
        输出:
        ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
        说明:
        按照假设，会访问"google.mail.com" 900次，"yahoo.com" 50次，"intel.mail.com" 1次，"wiki.org" 5次。
        而对于父域名，会访问"mail.com" 900+1 = 901次，"com" 900 + 50 + 1 = 951次，和 "org" 5 次。
        */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subdomain_Visit_Count {
    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> aryList = new ArrayList<String>();
        if (cpdomains == null || cpdomains.length == 0) return aryList;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String s : cpdomains) {
            test(s, map);
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            aryList.add(entry.getValue() + " " + entry.getKey());
        }
        return aryList;
    }

    static void test(String string, HashMap<String, Integer> map) {
        String[] strArys= string.split(" ");
        if (strArys.length != 2) return;;
        int startCount = Integer.valueOf(strArys[0]);
        String s = strArys[1];
        if (map.containsKey(s)) {
            map.put(s,map.get(s) + startCount);
        } else  {
            map.put(s,startCount);
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.' && (i + 1 ) < s.length()) {
                String subStr = s.substring(i + 1);
                if (map.containsKey(subStr)) {
                    map.put(subStr,map.get(subStr) + startCount);
                } else  {
                    map.put(subStr,startCount);
                }
            }
        }
    }
    
    public  static void main(String[] s) {
        String[] sAry = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(sAry));
    }
    
}
