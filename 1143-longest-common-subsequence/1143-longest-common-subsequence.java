class Solution {
    public int longestCommonSubsequence(String str1, String str2) {
        int [][]dp=new int[str1.length()][str2.length()];
		for(int []i:dp) {
			Arrays.fill(i, -1);
		}
		return longestSubsequence(str1, str2, 0, 0,dp);
    }
    private static int longestSubsequence(String str1, String str2, int i, int j,int [][]dp) {
		// TODO Auto-generated method stub
		if(i==str1.length()||j==str2.length()) {
			
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int ans=0;
		if(str1.charAt(i)==str2.charAt(j)) {
			ans=1+longestSubsequence(str1, str2, i+1, j+1,dp);
		}
		else {
			int fs=longestSubsequence(str1, str2, i+1, j,dp);
			int ss=longestSubsequence(str1, str2, i, j+1,dp);
			ans=Math.max(fs, ss);
		}
		return dp[i][j]=ans;
	}

   
}