class Solution {
    public int findComplement(int num) {
          char[] c= Integer.toBinaryString(num).toCharArray();
        for (int i=0;i<c.length;i++){
            c[i]=c[i]=='1'?'0':'1';
        }
        return Integer.parseInt(String.valueOf(c),2);
    }
}
