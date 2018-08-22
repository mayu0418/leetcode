class Solution {
    public  int matrixScore(int[][] A) {
        for (int i=0;i<A.length;i++){
            if (A[i][0]!=1) changH(A,i);
        }
        for (int i=0;i<A[0].length;i++){
            if (checkIfChangeV(A,i)) changeV(A,i);
        }
        int temp = 0;
        for (int i=0;i<A.length;i++){
            String s = Arrays.toString(A[i]).replace("[","")
                    .replace("]","")
                    .replace(",","").replace(" ","");
            temp+=Integer.parseInt(s,2);
        }

        return temp;
        }

        private  void changeV(int[][] A,int n){
        for (int i=0;i<A.length;i++){
            A[i][n]=A[i][n]==0?1:0;
        }
        }


        private   void changH(int[][] A,int n){
            for (int i=0;i<A[n].length;i++){
                A[n][i]=A[n][i]==0?1:0;
            }
        }
     private  boolean checkIfChangeV(int[][] A,int n){
        int temp =0;
            for (int i=0;i<A.length;i++){
                temp+=A[i][n];
            }
            return temp<=A.length/2;
        }
}
