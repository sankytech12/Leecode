class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return solve(nums,target);
    }
    private static List<List<Integer>> solve(int[] arr, int tar) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		List<List<Integer>> ans = new ArrayList<>();
		int n = arr.length;
		if (arr == null || n == 0)
			return ans;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				long tar2 = (long) tar - arr[i] - arr[j];
				int lo = j + 1, hi = n - 1;
				while (lo < hi) {
					long sum = (long)arr[lo] + (long)arr[hi];
					if (sum < tar2)
						lo++;
					else if (sum > tar2)
						hi--;
					else {
						ans.add(Arrays.asList(arr[i], arr[j], arr[lo], arr[hi]));
						while (lo < hi && arr[lo] == arr[lo + 1])
							lo++;
						while (lo < hi && arr[hi] == arr[hi - 1])
							hi--;
						lo++;
						hi--;
					}
				}
				while (j + 1 < n && arr[j] == arr[j + 1])
					j++;
			}
			while (i + 1 < n && arr[i] == arr[i + 1])
				i++;
		}
		return ans;
	}

}