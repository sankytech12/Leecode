class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum=0;
        int sum=0;
        for(int i:nums) sum+=i;
        for(int i=0;i<nums.length;i++){
            int rightSum=sum-nums[i]-leftSum;
            if(leftSum==rightSum) return i;
            leftSum+=nums[i];
        }
        return -1;
    }
}