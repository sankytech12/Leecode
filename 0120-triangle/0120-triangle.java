class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
    int dp[][]=new int[triangle.size()][triangle.size()];
        for(int []i:dp){
            Arrays.fill(i, -1);
        }
        int ans=solve(triangle,0,0,dp);
        return ans;
    }

    private static int solve(List<List<Integer>>  triangle, int i, int j,int [][]dp) {
        if(i==triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int down=solve(triangle, i+1, j,dp);
        int digonal=solve(triangle, i+1, j+1,dp);
        return dp[i][j]=triangle.get(i).get(j)+Math.min(down, digonal);
    }
}