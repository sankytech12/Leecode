class Solution {
    public int[] nextGreaterElement(int[] nums2, int[] nums1) {
        
    int []ans=new int[nums2.length];
		Stack<Integer> st=new Stack<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			while(!st.isEmpty()&&nums1[i]>nums1[st.peek()]) {
				int ii=st.pop();
				if(Search(nums2,nums1[ii])) {
				int idx=SearchI(nums2, nums1[ii]);
				ans[idx]=nums1[i];
				}
			}
			st.push(i);
		}
//		while(!st.isEmpty()) {
//			int ii=st.pop();
//			if(Search(nums2,nums1[ii])) {
//				int idx=SearchI(nums2, nums1[ii]);
//				ans[idx]=-1;
//				}
//		}
		for (int i = 0; i < ans.length; i++) {
			if(ans[i]==0) {
				ans[i]=-1;
			}
		}
		return ans;
	}

	private static boolean Search(int[] nums2, int n) {
		// TODO Auto-generated method stub
		for (int j = 0; j < nums2.length; j++) {
			if(nums2[j]==n) {
				return true;
			}
		}
		return false;
	}
	private static int SearchI(int[] nums2, int n) {
		// TODO Auto-generated method stub
		for (int j = 0; j < nums2.length; j++) {
			if(nums2[j]==n) {
				return j;
			}
		}
		return -1;
	}
}