class Solution {
    public String removeDuplicates(String s) {
        	Stack<Character> st=new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if(!st.isEmpty()&&s.charAt(i)==st.peek()) {
				st.pop();
			}
			else st.push(s.charAt(i));
		}
		StringBuilder ans=new StringBuilder();
		while(!st.isEmpty()) {
			ans.append(st.pop());
		}
		ans.reverse();
		return ans.toString();
    }
}