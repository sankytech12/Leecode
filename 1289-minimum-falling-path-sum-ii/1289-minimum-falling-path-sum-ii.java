class Solution {
    public int minFallingPathSum(int[][] arr) {
        
   int ans=Integer.MAX_VALUE;
		int [][]dp=new int[arr.length+1][arr[0].length+1];
		for(int []i:dp) {
			Arrays.fill(i, -1);
		}
		for (int i = 0; i < arr[0].length; i++) {
			ans=Math.min(ans, minFallin(arr,0,i,dp));
		}
		return ans;
	}

	private static int minFallin(int[][] arr, int i, int j,int [][]dp) {
		// TODO Auto-generated method stub
		if(j<0||j>=arr[0].length) {
			return Integer.MAX_VALUE;
		}
		if(i==arr.length-1) {
			return arr[i][j];
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		
		int cost=Integer.MAX_VALUE;
		for (int k = 0; k < dp[0].length-1; k++) {
			if(k!=j) {
			cost=Math.min(cost, minFallin(arr, i+1, k, dp));
			}
		}
		return dp[i][j]=arr[i][j]+ cost;
	}

}