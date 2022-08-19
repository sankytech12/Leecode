class Solution {
    public int minCostClimbingStairs(int[] arr) {
        int dp[]=new int[arr.length];
		Arrays.fill(dp, -1);
		return minCostBU(arr);
    }
    public static int helper(int []arr,int []dp) {
		int first=minCost(arr, dp, 0);
		int sec=minCost(arr, dp, 1);
		return Math.min(first, sec);
	}
	private static int minCost(int[] arr, int[] dp, int i) {
		// TODO Auto-generated method stub
		if(i>=arr.length) {
			return 0;
		}
		if(dp[i]!=-1) {
			return dp[i];
		}
		int first=minCost(arr, dp, i+1);
		int sec=minCost(arr, dp, i+2);
		return dp[i]=Math.min(first, sec)+arr[i];
	}
    private static int minCostBU(int[] arr) {
		// TODO Auto-generated method stub
		int dp[]=new int[arr.length];
		dp[0]=arr[0];
		dp[1]=arr[1];
		for (int i = 2; i < arr.length; i++) {
			dp[i]=Math.min(dp[i-1], dp[i-2])+arr[i];
		}
		return Math.min(dp[dp.length-1],dp[dp.length-2]);
	}
}