class Solution {
    public int minDistance(String str1, String str2) {
       int [][]dp=new int[str1.length()][str2.length()];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		return min(str1,str2,0,0,dp); 
    }
    private static int min(String str1, String str2, int i, int j,int [][]dp) {
		// TODO Auto-generated method stub
		if(i==str1.length()) {
			return str2.length()-j;
		}
		if(j==str2.length()) {
			return str1.length()-i;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int ans=0;
		if(str1.charAt(i)==str2.charAt(j)) {
			ans=min(str1, str2, i+1, j+1,dp);
		}else {
			int delete=min(str1, str2, i+1, j,dp);
			int insert=min(str1, str2, i, j+1,dp);
			ans=Math.min(insert, delete)+1;
		}
		return dp[i][j]=ans;
	}
}