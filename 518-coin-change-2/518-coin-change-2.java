class Solution {
    public int change(int amt, int[] arr) {
        int [][]dp=new int[amt+1][arr.length];
		for(int[] i:dp) {
			Arrays.fill(i, -1);
		}
		return coinChange(arr,0,amt,dp);
    }
    
	private static int coinChange(int[] arr, int i,int amt,int [][]dp) {
		// TODO Auto-generated method stub
		if(amt==0) {
			return 1;
		}
		if(i==arr.length) {
			return 0;
		}
		if(dp[amt][i]!=-1) {
			return dp[amt][i];
		}
		int inc=0;
		int exc=0;
		if(arr[i]<=amt) {
			inc=coinChange(arr, i, amt-arr[i],dp);
		}
		exc=coinChange(arr, i+1, amt,dp);
		return dp[amt][i]=inc+exc;
	}
}