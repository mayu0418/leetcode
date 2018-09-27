class Solution {
        public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<List<String>>();
        if(s.length()==0)return res;
        DFS(res,new ArrayList<String>(),s);
        return res;
    }

    public void DFS(List<List<String>> res,List<String> out, String s){
        if(s.length()==0){
            res.add(new ArrayList<String>(out));
            return;
        }
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s.substring(0,i+1))){
                out.add(s.substring(0,i+1));
                DFS(res,out,s.substring(i+1));
                out.remove(out.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while ( start< end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            ++start;
            --end;
        }
        return true;
    }

}
