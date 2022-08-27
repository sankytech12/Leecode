class Solution {
    public int minFallingPathSum(int[][] arr) {
        
    int ans=Integer.MAX_VALUE;
		int [][]dp=new int[arr.length][arr[0].length];
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
		
		int leftd=minFallin(arr, i+1, j-1,dp);
		int down=minFallin(arr, i+1, j,dp);
		int rightd=minFallin(arr, i+1, j+1,dp);
		return dp[i][j]=arr[i][j]+Math.min(down, Math.min(leftd, rightd));
	}

}