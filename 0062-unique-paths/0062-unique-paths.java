class Solution {
    //static int count=0;
    public int uniquePaths(int m, int n) {
        int arr[][]=new int[n][m];
        int dp[][]=new int[n+1][m+1];
        for(int []i:dp){
            Arrays.fill(i, -1);
        }
        return solve(arr,0,0,dp);
        
    }

    private static int solve(int[][] arr,int i,int j,int [][]dp) {
        if(i==arr.length-1 && j==arr[0].length-1){
            return 1;
        }
        if(i>arr.length || j>arr[0].length) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right=0,down=0;
         right+=solve(arr, i, j+1,dp);
         down+=solve(arr, i+1, j,dp);
        return dp[i][j]=right+down;
    }

}