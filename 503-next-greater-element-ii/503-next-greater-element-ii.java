class Solution {
    public int[] nextGreaterElements(int[] arr) {
       Stack<Integer> st=new Stack<Integer>();
		int n=arr.length;
		int []nge=new int[n];
		Arrays.fill(nge, -1);
		for (int i = 0; i < 2*n; i++) {
			while(!st.isEmpty()&&arr[i%n]>arr[st.peek()]) {
					int ii=st.pop();
					nge[ii]=arr[i%n];
				}
			if(i<n) st.push(i);
			}
		
		return nge;

    }
}