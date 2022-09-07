class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll=new ArrayList<String>();
		Paranthesis(n, 0, 0, "",ll);
        return ll;
    }
    public static void Paranthesis(int n,int opening,int closing,String ans,List<String> ll) {
		if(opening==n&&closing==n) {
			ll.add(ans);
			return;
		}
		if(opening<=n) {
		Paranthesis(n,opening+1, closing, ans+"(",ll);
		}
		if(closing<opening) {
			Paranthesis(n, opening, closing+1, ans+")",ll);
		}
	}
}