class Solution {
    public int hammingDistance(int x, int y) {
         int temp = x^y;
        int length =0;
        for (int i=0;i<=31;i++){
            length+=(temp&(1<<i))>>i;
        }
        return length;
    }
}
