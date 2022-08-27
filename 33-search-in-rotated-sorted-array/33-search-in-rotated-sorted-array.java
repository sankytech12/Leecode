class Solution {
    public int search(int[] arr, int target) {
        int idx = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				idx = i;
				break;
			}
		}
		int first = binarySearch(arr, 0, idx - 1, target);
		int second = binarySearch(arr, idx, arr.length - 1, target);
		if (first != -1) {
			return first;
		} else {
			return second;
		}
    }
    private static int binarySearch(int[] arr, int lo, int hi,int target) {
		// TODO Auto-generated method stub
		while(lo<=hi) {
			int mid=lo+(hi-lo)/2;
			if(arr[mid]==target) {
				return mid;
			}
			else if(arr[mid]>target) {
				hi=mid-1;
			}
			else {
				lo=mid+1;
			}
		}
		return -1;
	}
}