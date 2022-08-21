class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int range=0;
		for (int i = 0; i < arr.length; i++) {
			range+=arr[i];
		}
		int s1=(range-target);
		if( s1<0 || s1%2==1 ) {
			return 0;
		}
        s1/=2;
		int [][]dp=new int [arr.length+1][s1+2000+5];
		for(int []i:dp) {
			Arrays.fill(i, -1);
		}
		return count(arr,s1,0,dp);
    }
  	private static int count(int[] arr, int n,int i,int [][]dp) {
		// TODO Auto-generated method stub
		
		if(i==arr.length) {
            if(n==0) {
			return 1;
		    }
			return 0;
		}
		if(dp[i][n+1000]!=-1) {
			return dp[i][n+1000];
		}
		int inc=0;
		int exc=0;
		if(n>=arr[i]) {
			inc=count(arr, n-arr[i], i+1,dp);
		}
		exc=count(arr, n, i+1,dp);
		return dp[i][n+1000]=inc+exc;
	}

}