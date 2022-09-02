class Solution {
    public int maxSubArray(int[] nums) {
        int psum=0;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            psum+=nums[i];
            ans=Math.max(ans,psum);
            if(psum<0){
                psum=0;
            }
        }
        return ans;
    }
}