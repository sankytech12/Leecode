class Solution {
    public int maxUncrossedLines(int[] arr1, int[] arr2) {
        int [][]dp=new int[arr1.length][arr2.length];
		for(int i[]:dp) {
			Arrays.fill(i, -1);
		}
		return maxUncrossed(arr1,arr2,0,0,dp);
    }
    private static int maxUncrossed(int[] arr1, int[] arr2, int i, int j,int [][]dp) {
		// TODO Auto-generated method stub
		if(i==arr1.length||j==arr2.length) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int ans=0;
		if(arr1[i]==arr2[j]) {
			ans=1+maxUncrossed(arr1, arr2, i+1, j+1,dp);
		}
		else {
			int fs=maxUncrossed(arr1, arr2, i+1, j,dp);
			int ss=maxUncrossed(arr1, arr2, i, j+1,dp);
			ans=Math.max(fs, ss);
		}
		return dp[i][j]=ans;
	}
}