class Solution {
    public int maxProfit(int[] arr) {
        int [][]dp=new int[arr.length][2];
		for(int i[]:dp) {
			Arrays.fill(i, -1);
		}
		return max(arr,1,0,dp);
    }
    private static int max(int[] arr, int buy,int i,int [][]dp) {
		// TODO Auto-generated method stub
		if(i==arr.length) return 0;
		if( dp[i][buy]!=-1) {
			return  dp[i][buy];
		}
		int profit=0;
		if(buy==1) {
			profit=Math.max(-arr[i]+max(arr, 0, i+1,dp), 
					0+max(arr, 1, i+1,dp));
			
		}else {
			profit=Math.max(arr[i]+max(arr, 1, i+1,dp), 
					0+max(arr, 0, i+1,dp));
		}
		
			
		return dp[i][buy]=profit;
	}
}