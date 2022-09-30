class Solution {
    public int singleNonDuplicate(int[] nums) {
        // int ee=0;
        // for(int i=0;i<nums.length;i++){
        //     ee=ee^nums[i];
        // }
        // return ee;
        return sin(nums);
    }
    public int sin(int []nums){
        int lo=0,hi=nums.length-2;
        while(lo<=hi){
            int mid=(lo+hi)>>1;
            if(nums[mid]==nums[mid^1]){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return nums[lo];
    }
}