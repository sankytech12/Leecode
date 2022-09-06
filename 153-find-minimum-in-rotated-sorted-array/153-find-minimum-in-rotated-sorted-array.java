class Solution {
    public int findMin(int[] arr) {
        int idx=-1;
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i]>arr[i+1]) {
				idx=arr[i+1];
				break;
			}
		}
		if(idx==-1) return arr[0];
		return idx;
    }
}