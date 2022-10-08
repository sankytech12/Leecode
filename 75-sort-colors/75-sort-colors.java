class Solution {
    public void sortColors(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int mid=0;
        while(mid<=r){
            if(nums[mid]==2){
                int t=nums[r];
                nums[r]=nums[mid];
                nums[mid]=t;
                r--;
            }
            else if(nums[mid]==0){
                int t=nums[l];
                nums[l]=nums[mid];
                nums[mid]=t;
                l++;
                mid++;
            }else mid++;
        }
    }
}