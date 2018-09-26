class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] n = a.split("\\+");
        String[] m = b.split("\\+");
        String s1 = n[0];
        String s2 = n[1];
        String s3 = s2.substring(0,s2.length()-1);
        String k1 = m[0];
        String k2 = m[1];
        String k3 = k2.substring(0,k2.length()-1);
        int n1 = Integer.parseInt(s1)*Integer.parseInt(k1)-Integer.parseInt(s3)*Integer.parseInt(k3);
        int n2 = Integer.parseInt(s3)*Integer.parseInt(k1)+Integer.parseInt(s1)*Integer.parseInt(k3);
        return String.valueOf(n1)+"+"+n2+"i";
    }
}
