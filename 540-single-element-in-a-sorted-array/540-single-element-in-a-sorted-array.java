class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ee=0;
        for(int i=0;i<nums.length;i++){
            ee=ee^nums[i];
        }
        return ee;
    }
}