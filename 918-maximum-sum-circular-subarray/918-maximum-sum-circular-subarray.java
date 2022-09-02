class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       
        int ans=MaxCSum(nums);
        return ans;
    }
   public static int MaxCSum(int[] arr) {
		// TODO Auto-generated method stub
		int Linear_Kadane=Kadane(arr);
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
			arr[i]=arr[i]*-1;
		}
		int lin_kadane=Kadane(arr);
		int Circ_kadane=lin_kadane+sum;
       if(Circ_kadane==0){
           return  Linear_Kadane;
       }
		return Math.max(Linear_Kadane, Circ_kadane);
	}
	public static int Kadane(int []arr) {
		int ans=Integer.MIN_VALUE;
		int prevsum=0;
		for (int i = 0; i < arr.length; i++) {
			prevsum+=arr[i];
			ans=Math.max(ans, prevsum);
			if(prevsum<0) {
				prevsum=0;
			}
			
		}
		return ans;
	}

}