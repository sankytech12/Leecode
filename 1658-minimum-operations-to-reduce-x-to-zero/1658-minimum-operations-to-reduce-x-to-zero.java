class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=Arrays.stream(nums).sum();
        int target=sum-x;
        if(target<0) return -1;
        if(target==0) return nums.length;
        int n=nums.length;
        int curr=0;
        int ans=Integer.MAX_VALUE;
        int si=0,ei=0;
        while(ei<n){
            curr+=nums[ei];
            while(curr>target && si<n){
                curr-=nums[si++];
            }
            if(curr==target) ans=Math.min(ans,n-(ei-si+1));
            ei++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}