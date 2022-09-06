class Solution {
    public int[] searchRange(int[] nums, int target) {
        return fAndL(nums,target);
    }
    private static int[] fAndL(int[] arr, int ele) {
		// TODO Auto-generated method stub
		int  []ans=new int[2];
		int lo=0;
		int hi=arr.length-1;
		int first=-1;
		int last=-1;
		while(lo<=hi) {
			int mid=(lo+hi)/2;
			if(arr[mid]==ele) {
				last=mid;
				lo=mid+1;
			}else if(arr[mid]>ele){
				hi=mid-1;
			}else {
				lo=mid+1;
			}
		}
		 lo=0;
		 hi=arr.length-1;
		while(lo<=hi) {
			int mid=(lo+hi)/2;
			if(arr[mid]==ele) {
				first=mid;
				hi=mid-1;
			}else if(arr[mid]>ele){
				hi=mid-1;
			}else {
				lo=mid+1;
			}
		}
		// if(first==-1&&last==-1){
		//     ans.add(first);
		// }
		// else{
		//     ans.add(first);
		//     ans.add(last);
		// }
        ans[0]=first;
        ans[1]=last;
		return ans;
	}
}