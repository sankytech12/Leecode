class Solution {
    public int coinChange(int[] coins, int amount) {
        return minCoin(coins,amount);

    }
    private static int minCoin(int[] arr, int sum) {
		// TODO Auto-generated method stub
		int [][]dp=new int[arr.length+1][sum+1];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i]=Integer.MAX_VALUE-1;
		}
		for (int i = 1; i < dp.length; i++) {
			dp[i][0]=0;
		}
		// for (int i = 1; i < dp[0].length; i++) {
		// 	if(i%arr[0]==0) {
		// 		dp[1][i]=i/arr[0];
		// 	}
		// 	else {
		// 		dp[1][i]=Integer.MAX_VALUE-1;
		// 	}
		// }
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				
				if(j>=arr[i-1]) {
					dp[i][j]=Math.min(1+dp[i][j-arr[i-1]], dp[i-1][j]);
				}
				else {
					dp[i][j]=dp[i-1][j];
				}
				
			}
		}
		
		return dp[arr.length][sum]==Integer.MAX_VALUE-1?-1:dp[arr.length][sum];
		
	}
}