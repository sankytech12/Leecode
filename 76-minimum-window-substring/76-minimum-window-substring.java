class Solution {
    public String minWindow(String s, String t) {
        int si=0;
		int ei=0;
		int frqs[]=new int[256];
		int frqt[]=new int[256];
		for (int i = 0; i < t.length(); i++) {
			char ch=t.charAt(i);
			frqt[ch]++;
		}
		int ws=Integer.MAX_VALUE;
		int count=0;
		int start=-1;
		while(ei<s.length()) {
			char ch=s.charAt(ei);
			frqs[ch]++;
			if(frqt[ch]>=frqs[ch]) {
				count++;
			}
			
			if(count==t.length()) {
				while(frqs[s.charAt(si)]>frqt[s.charAt(si)]) {
					frqs[s.charAt(si)]--;
					si++;
				}
				if(ws>ei-si+1) {
					ws=ei-si+1;
					start=si;
				}
			}
			ei++;
		}
		if(start==-1) {
			return "";
		}
		return s.substring(start, start+ws);
    }
    
}