class Solution {
    public int numDistinct(String s, String t) {
        int [][]dp=new int[t.length()+1][s.length()+1];
		for(int []i:dp) {
			Arrays.fill(i, -1);
		}
		return seq(s,t,0,0,dp);
    }
    private static int seq(String s, String t, int i, int j, int[][] dp) {
		// TODO Auto-generated method stub
		if(i==t.length()) {
			return 1;
			
		}
		if(j==s.length()) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int inc=0;
		int exc=0;
		
		if(s.charAt(j)==t.charAt(i)) {
			inc=seq(s, t, i+1, j+1, dp);
		}
		exc=seq(s, t, i, j+1, dp);
		
		return dp[i][j]=inc+exc;
	}

}