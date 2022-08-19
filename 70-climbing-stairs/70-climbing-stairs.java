class Solution {
    public int climbStairs(int n) {
       int []dp=new int[n+1];
        return climb(n,dp);
    }
    private static int climb(int n, int[] dp) {
		// TODO Auto-generated method stub
		if(n==1||n==0) {
			return 1;
		}
		if(dp[n]!=0) {
			return dp[n];
		}
		int o=climb(n-1, dp);
		int t=climb(n-2, dp);
		return dp[n]=o+t;
	}
}