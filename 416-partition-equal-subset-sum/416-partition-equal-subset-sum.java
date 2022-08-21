class Solution {
    public boolean canPartition(int[] nums) {
        return isPossible(nums);
    }
    private static boolean isPossible(int[] nums) {
		// TODO Auto-generated method stub
		int sum=0;
		for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
		}
		if(sum%2!=0) {
			return false;
		}
		else {
			return isPresentBU(nums, sum/2);
		}
	}
	private static boolean isPresentBU(int[] arr, int wt) {
		// TODO Auto-generated method stub
		boolean [][]dp=new boolean[arr.length+1][wt+1];
		
		for (int i = 0; i < dp.length; i++) {
			dp[i][0]=true;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int w = 1; w < dp[0].length; w++) {
				boolean inc=false;
				boolean exc;
				if(w>=arr[i-1]) {
					inc=dp[i-1][w-arr[i-1]];
				}
				exc=dp[i-1][w];
				dp[i][w]=inc||exc;
			}
		}
	
		return dp[arr.length][wt];
	}
}