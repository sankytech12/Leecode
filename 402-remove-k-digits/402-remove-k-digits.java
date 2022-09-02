class Solution {
    public String removeKdigits(String s, int k) {
        if(s.length()==k){
            return "0";
        }
        Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {

			while (!st.isEmpty() && k > 0 && st.peek() > s.charAt(i)) {
				st.pop();
				k--;
			}
			st.push(s.charAt(i));
		}
		while(!st.isEmpty()&&k>0) {
			st.pop();
			k--;
		}
		StringBuilder sb=new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		sb.reverse();
		while(sb.length()>0 &&sb.charAt(0)=='0') {
			sb.deleteCharAt(0);
		}
		return sb.length()==0?"0":sb.toString();
    }
}