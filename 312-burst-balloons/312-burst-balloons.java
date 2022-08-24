class Solution {
    public int maxCoins(int[] nums) {
        
   int n=nums.length;
		int []arr=new int[n+2];
		arr[0]=1;
		arr[arr.length-1]=1;
		for (int i = 0; i < nums.length; i++) {
			arr[i+1]=nums[i];
		}
		int [][]dp=new int[arr.length][arr.length];
		for(int i[]:dp) {
			Arrays.fill(i, -1);
		}
		return maxCoin(arr,1,n,dp);
	}

	private static int maxCoin(int[] nums, int i, int j,int [][]dp) {
		// TODO Auto-generated method stub
		if(i>j) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int max=Integer.MIN_VALUE;
		for (int k = i; k <=j; k++) {
			int le=nums[i-1];
			int re=nums[j+1];
			int coins=le*nums[k]*re;
			int lp=maxCoin(nums, i, k-1,dp);
			int rp=maxCoin(nums, k+1, j,dp);
			int ans=lp+rp+coins;
			max=Math.max(max, ans);
		}
		return dp[i][j]= max;
	}
}