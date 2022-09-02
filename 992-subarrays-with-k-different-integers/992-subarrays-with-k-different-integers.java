class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return solve(nums,k)-solve(nums,k-1);
    }
    private static int solve(int[] arr, int k) {
		// TODO Auto-generated method stub
		int si=0;
		int ei=0;
		int ans=0;
		int unq=0;
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		while(ei<arr.length) {
			int i=arr[ei];
			if(!map.containsKey(i)) {
				map.put(i, 1);
				unq++;
			}
			else {
			map.put(i, map.get(i)+1);
			}
			while(unq>k&&si<=ei) {
				int ii=arr[si];
				map.put(ii, map.get(ii)-1);
				if(map.get(ii)==0) {
                    map.remove(ii);
					unq--;
				}
				si++;
			}
			
			ans=ans+ei-si+1;
			ei++;
        }
        return ans;
	}
}