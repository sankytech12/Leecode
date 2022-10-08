class Solution {
    public void nextPermutation(int[] nums) {
        nextperm(nums);
    }
    public static void nextperm(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		int p = 0;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				p = i;
				break;
			}
		}
		int q = 0;
		for (int i = arr.length - 1; i > p; i--) {
			if (arr[i] > arr[p]) {
				q = i;
				break;
			}
		}
		if(p==0&&q==0) {
			Reverse(arr, 0, arr.length-1);
			return;
		}
		int t = arr[p];
		arr[p] = arr[q];
		arr[q] = t;
		Reverse(arr, p + 1, arr.length-1);
		
	}

	public static void Reverse(int[] arr, int i, int j) {

		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}

	}
}