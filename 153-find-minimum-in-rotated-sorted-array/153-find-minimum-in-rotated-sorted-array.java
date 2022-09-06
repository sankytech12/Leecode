class Solution {
    public int findMin(int[] arr) {
		// int idx=-1;
		// for (int i = 0; i < arr.length-1; i++) {
		// 	if(arr[i]>arr[i+1]) {
		// 		idx=arr[i+1];
		// 		break;
		// 	}
		// }
		// if(idx==-1) return arr[0];
		// return idx;
        return rotation2(arr);
    }
    private static int rotation2(int[] arr) {
		int lo=0;
		int hi=arr.length-1;
		int ans=-1;
		int n=arr.length;
		while(lo<=hi) {
			int mid=(lo+hi)/2;
			// int prev=(mid+n-1)%n;
			// int next=(mid+1)%n;
			if(mid>0 && arr[mid]<arr[mid-1])  {
                System.out.print(arr[mid]);
				return arr[mid];
			}else if(arr[lo]<=arr[mid]&&arr[mid]>arr[hi]) {
				lo=mid+1;
			}else {
				hi=mid-1;
			}
		}
		return arr[0];
	}
}
