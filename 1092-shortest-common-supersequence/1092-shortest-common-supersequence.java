class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return lcs(str1,str2);
    }
    private static String lcs(String str1, String str2) {
		// TODO Auto-generated method stub
		int [][]dp=new int[str1.length()+1][str2.length()+1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				int ans=0;
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					ans=dp[i-1][j-1]+1;
				}
				else {
					ans=Math.max(dp[i-1][j], dp[i][j-1]);
				}
				dp[i][j]=ans;
			}
		}
		int i=str1.length();
		int j=str2.length();
		StringBuilder sb=new StringBuilder();
		while(i>0&&j>0) {
			if(str1.charAt(i-1)==str2.charAt(j-1)) {
				sb.append(str1.charAt(i-1));
				i--;
				j--;
			}else {
				if(dp[i][j-1]>dp[i-1][j]) {
					sb.append(str2.charAt(j-1));
					j--;
				}else {
					sb.append(str1.charAt(i-1));
					i--;
				}
			}
		}
		while(i>0) {
			sb.append(str1.charAt(i-1));
			i--;
		}
		while(j>0) {
			sb.append(str2.charAt(j-1));
			j--;
		}
		sb.reverse();
		return sb.toString();
	}
	
	

}