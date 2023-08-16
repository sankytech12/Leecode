class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        return max(nums,k);
    }
     private static int[] max(int[] arr, int k) {
		// TODO Auto-generated method stub
		int []ans=new int[arr.length-k+1];
		Deque<Integer> dq=new ArrayDeque<Integer>();
		int idx=0;
		
		for (int i = 0; i < arr.length; i++) {
			if(!dq.isEmpty() && dq.peek()==i-k) {
				dq.poll();
			}
			while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]) {
				dq.pollLast();
			}
			dq.offer(i);
			if(i>=k-1) {
				ans[idx++]=arr[dq.peek()];
			}
		}
		return ans;
		
	}
}