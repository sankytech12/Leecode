class Solution {
    public int minInsertions(String s) {
        
    StringBuilder sb=new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.insert(0, s.charAt(i));
		}
		String s1=sb.toString();
		int [][]dp=new int[s.length()][s1.length()];
		for(int i[]:dp) {
			Arrays.fill(i, -1);
		}
       
		return s.length()-min(s,s1,0,0,dp);
	}
private static int min(String s, String s1,int i,int j,int [][]dp) {
		// TODO Auto-generated method stub
		if(i==s.length()||j==s1.length()) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int ans=0;
		if(s.charAt(i)==s1.charAt(j)) {
			ans=1+min(s, s1, i+1, j+1, dp);
		}
		else {
			ans=Math.max(min(s, s1, i+1, j, dp), min(s, s1, i, j+1, dp));
		}
		return dp[i][j]= ans;
	}


}