class Solution {
    public int minCost(int n, int[] arr) {
       Arrays.sort(arr);
		int len=arr.length;
		int [][]dp=new int[len+1][len+1];
		for(int []i:dp) {
			Arrays.fill(i, -1);
		}
		return minCost(arr,0,arr.length,n,dp);
	}

	private static int minCost(int[] arr, int i, int j, int n,int [][]dp) {
		// TODO Auto-generated method stub
		if(i>=j) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int min=Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int le=i==0?0:arr[i-1];
			int re=j==arr.length?n:arr[j];
			int cost=re-le;
			int lp=minCost(arr, i, k, le,dp);
			int rp=minCost(arr, k+1, j,re,dp);
			int ans=cost+lp+rp;
			min=Math.min(min, ans);
		}
		return dp[i][j]=min;
	}
   
}