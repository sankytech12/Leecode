class Solution {
    public int lengthOfLIS(int[] nums) {
        return solve(nums);
    }
    	private static int maxLen(int[] arr) {
		// TODO Auto-generated method stub
		int []ans=new int[arr.length];
		ans[0]=arr[0];
		int len=1;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]>ans[len-1]) {
				ans[len]=arr[i];
				len++;
			}else {
				int idx=BinarySearch(ans,0,len-1,arr[i]);
				ans[idx]=arr[i];
			}
		}
		return len;
	}
    public int solve(int []arr){
        int n=arr.length;
        int[]dp=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    ans=Math.max(ans,dp[i]);
                }
            }
        }
         return ans==0?1:ans;
    }
	private static int BinarySearch(int[] ans, int lo, int hi, int item) {
		// TODO Auto-generated method stub
		int idx=0;
		while(lo<=hi) {
			int mid=(lo+hi)/2;
			if(ans[mid]>=item) {
				idx=mid;
				hi=mid-1;
			}else {
				lo=mid+1;
			}
		}
		return idx;
	}
}