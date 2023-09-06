class Solution {
    public int[] rearrangeArray(int[] nums) {
        int p=0,ne=1;
        int n=nums.length;
        int []arr=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                arr[ne]=nums[i];
                ne+=2;
            }else{
                arr[p]=nums[i];
                p+=2;
            }
        }
        return arr;
    }
}