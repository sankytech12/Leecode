class Solution {
    public int rob(int[] nums) {
       int []dp=new int[nums.length];
		Arrays.fill(dp, -1);
		
		return maxRobbed(nums,0,dp);
	}

	private static int maxRobbed(int[] arr,int i,int []dp) {
		// TODO Auto-generated method stub
		if(i>=arr.length) {
			return 0;
		}
		if(dp[i]!=-1) {
			return dp[i];
		}
		int rob=arr[i]+maxRobbed(arr, i+2,dp);
		int norob=maxRobbed(arr, i+1,dp);
		return dp[i]=Math.max(rob, norob);
	}
	

} 
    
