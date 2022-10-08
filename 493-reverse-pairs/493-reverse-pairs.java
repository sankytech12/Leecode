class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
	}
	// private static int mergeSort(int[] arr, int i, int j) {
	// 	// TODO Auto-generated method stub
	// 	if(i>=j) return 0;
	// 	int count=0;
	// 	int mid=(i+j)/2;
	// 	count+=mergeSort(arr, i, mid);
	// 	count+=mergeSort(arr, mid+1, j);
	// 	count+=merge(arr,i,mid,j);
	// 	return count;
	// }
 private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0; 
        int mid = s + (e-s)/2; 
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e); 
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++; 
            cnt += j-(mid+1); 
        }
        Arrays.sort(nums, s, e+1); 
        return cnt; 
    }
	private static int merge(int[] arr, int low, int mid, int high) {
		// TODO Auto-generated method stub
		
		int j=mid+1;
		int count=0;
		for (int i = low; i <=mid; i++) {
			while(j<=high && arr[i]>(2*(long)(arr[j]))) {
				j++;
			}
			count+=(j-(mid+1));
		}
		ArrayList<Integer> temp=new ArrayList<>();
		int left=low,right=mid+1;
		while(left<=mid && right<=high) {
			if(arr[left]<=arr[right]) {
				temp.add(arr[left++]);
			}else {
				temp.add(arr[right++]);
			}
		}
		while(left<=mid) {
			temp.add(arr[left++]);
		}
		while(right<=high) {
			temp.add(arr[right++]);
		}
		for(int i=low;i<=high;i++) {
			arr[i]=temp.get(i-low);
		}
		return count;
	}

}