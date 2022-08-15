class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        for(int i=0;i<nums.length/2;i++){
            int pair=nums[i]+nums[nums.length-1-i];
            res=Math.max(pair,res);
        }
        return res;
    }
}