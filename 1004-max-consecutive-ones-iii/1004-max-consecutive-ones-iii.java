class Solution {
    public int longestOnes(int[] nums, int k) {
        int ei=0,si=0;
        int ans=-1;
        while(ei<nums.length){
           
             if(nums[ei]==0){
                
                k--;
            }
            while(k<0 && si<=ei){
                if(nums[si]==0) k++;
                si++;
            }
           
            ans=Math.max(ans,ei-si+1);
             ei++;
        }
        return ans;
    }
}