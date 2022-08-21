class Solution {
    public int change(int amt, int[] arr) {
        int [][]dp=new int[amt+1][arr.length];
		for(int[] i:dp) {
			Arrays.fill(i, -1);
		}
		return coinChangeBU(arr,amt);
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
    private static int coinChangeBU(int[] arr,int amt) {
		// TODO Auto-generated method stub
		int [][]dp=new int[arr.length+1][amt+1];
		for (int j = 0; j < dp.length; j++) {
			dp[j][0]=1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int w = 1; w < dp[0].length; w++) {
				int inc=0;
				int exc=0;
				if(w>=arr[i-1]) {
					inc=dp[i][w-arr[i-1]];
				}
				exc=dp[i-1][w];
				dp[i][w]=inc+exc;
			}
		}
		return dp[arr.length][amt];
	}

}