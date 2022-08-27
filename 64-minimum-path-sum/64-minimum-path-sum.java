class Solution {
    public int minPathSum(int[][] grid) {
        int [][]dp=new int[grid.length][grid[0].length];
   for(int []i:dp) {
			Arrays.fill(i, -1);
		}
		return minPath(grid,0,0,dp);
	}

	private static int minPath(int[][] arr, int i, int j,int [][]dp) {
		if(i==arr.length-1&&j==arr[0].length-1) {
			return arr[i][j];
		}
		// TODO Auto-generated method stub
		if(i>=arr.length||j>=arr[0].length) {
			return Integer.MAX_VALUE;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		
		int down=minPath(arr, i+1, j,dp);
		int right=minPath(arr, i, j+1,dp);
		return dp[i][j]=arr[i][j]+Math.min(down, right);
	}
}