class Solution {
    public int maxDotProduct(int[] arr1, int[] arr2) {
        
		return maxProduct(arr1,arr2);
    }
   private static int maxProduct(int[] nums1, int[] nums2) {
		// TODO Auto-generated method stub
		int [][]dp=new int[nums1.length][nums2.length];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j]=nums1[i]*nums2[j];
				if(i==0&&j>0) {
					dp[i][j]=Math.max(dp[i][j], dp[i][j-1]);
				}
				if(j==0&&i>0) {
					dp[i][j]=Math.max(dp[i][j], dp[i-1][j]);
				}
				if(i>0&&j>0) {
					dp[i][j]=Math.max(dp[i][j]+Math.max(0,dp[i-1][j-1]), Math.max(dp[i][j-1], dp[i-1][j]));
				}
			}
		}
		return dp[nums1.length-1][nums2.length-1];
	}
    
}