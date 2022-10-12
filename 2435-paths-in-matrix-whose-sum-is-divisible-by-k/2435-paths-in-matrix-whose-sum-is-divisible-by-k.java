class Solution {
    static int mod=(int)1e9+7;
    public int numberOfPaths(int[][] arr, int k) {
    int [][][]dp=new int[arr.length][arr[0].length][51];
		for(int [][]t:dp) {
			for(int []o:t) {
				Arrays.fill(o, -1);
			}
		}
	int ans=(int) solve(arr,k,0,0,0,dp);
	return ans;
	}
	
	private static long solve(int[][] arr, int k, int i, int j, int sum,int [][][]dp) {
		// TODO Auto-generated method stub
		if(i<0 || i>=arr.length || j<0 || j>=arr[0].length) {
			return 0;
		}
		if(i==arr.length-1 && j==arr[0].length-1) {
			sum+=arr[i][j];
			if(sum%k==0) {
				return 1;
			}
			return 0;
		}
		if(dp[i][j][sum%k]!=-1) {
			return dp[i][j][sum%k];
		}
		long down=solve(arr, k, i+1, j, sum+arr[i][j],dp);
		long left=solve(arr, k, i, j+1, sum+arr[i][j],dp);
		return dp[i][j][sum%k]=(int) ((down%mod+left%mod)%mod);
	}
}