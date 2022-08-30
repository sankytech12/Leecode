class Solution {
    public int calPoints(String[] arr) {
        Stack<Integer> st=new Stack<>();
		int ans=0;
		for (int i = 0; i < arr.length; i++) {
			if(!arr[i].equals("C")&&!arr[i].equals("D")&&!arr[i].equals("+")) {
				int add=Integer.valueOf(arr[i]);
				st.push(add);
			}
			else if(arr[i].equals("C")) {
				st.pop();
			}
			else if(arr[i].equals("D")) {
				int n=2*st.peek();
				st.push(n);
			}else if(arr[i].equals("+")) {
				int rvi=st.pop();
				int rv2=st.peek();
				int sum=rvi+rv2;
				st.push(rvi);
				st.push(sum);
			}
		}
		while(!st.isEmpty()) {
			ans+=st.pop();
		}
		return ans;
    }
}