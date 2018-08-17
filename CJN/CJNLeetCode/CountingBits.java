class Solution {
    public int[] countBits(int num) {
        int[] array= new int[num+1];
        for (int i=0;i<=num;i++){
            int temp =0;
            for (int j=0;j<=31;j++){
                temp+=(i&(1<<j))>>j;
            }
           array[i] = temp;
        }
        return array;
    }
}
