class Solution {
    public int numTrees(int n) {
        if(n==0||n==1){
            return n;
        }
        int []dp=new int[n+1];
            dp[0]=1;
            dp[1]=1; 
        for(int i=2;i<=n;i++){
            int sum=0;
            for(int j=1;j<=i;j++){
                int leftBst=dp[j-1];
                int rightBst=dp[i-j];
                sum+=leftBst*rightBst;
                
            }
            dp[i]=sum;
        }
        return dp[n];
    }
}