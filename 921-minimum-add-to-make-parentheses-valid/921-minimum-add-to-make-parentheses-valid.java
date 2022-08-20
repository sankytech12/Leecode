class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<Character>();
		int cnt=0;
		for (int i = 0; i <s.length(); i++) {
			if(s.charAt(i)=='(') {
				st.push(s.charAt(i)); 
			}else {
				if(st.isEmpty()) {
					cnt++;
				}
				else {
					st.pop();
				}
			}
		}
		cnt+=st.size();
		return cnt;
    }
}