class Solution {
    public int longestPalindromeSubseq(String str1) {
       StringBuilder sb=new StringBuilder();
		for (int i = str1.length()-1; i >=0; i--) {
			
			sb.append(str1.charAt(i));
		}
		String str2=sb.toString();
		return lcs(str1,str2);
	}

	private static int lcs(String str1, String str2) {
		// TODO Auto-generated method stub
		int [][]dp=new int[str1.length()+1][str2.length()+1];
		
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				int ans=0;
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					ans=1+dp[i-1][j-1];
				}
				else {
					ans=Math.max(dp[i-1][j], dp[i][j-1]);
				}
				dp[i][j]=ans;
			}
		}
		return dp[str1.length()][str2.length()];
	}
}