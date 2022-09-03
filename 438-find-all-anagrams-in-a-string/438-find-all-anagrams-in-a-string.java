class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        return noAnagram2(s,p);
    }
    private static ArrayList<Integer> noAnagram2(String s, String t) {
		// TODO Auto-generated method stub
		int ei = 0;
		int si = 0;
		ArrayList<Integer> ll=new ArrayList<Integer>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			if (map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
			} else
				map.put(t.charAt(i), 1);
		}
		int ans = 0;
		int count = map.size();
		int k = t.length();
		while (ei < s.length()) {
			char ch = s.charAt(ei);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) - 1);
				if (map.get(ch) == 0) {
					count--;
				}
			}
			while(ei-si+1>k && si<=ei) {
				char c=s.charAt(si);
				if(map.containsKey(c)) {
					if(map.get(c)==0) {
						count++;
					}
					map.put(c, map.get(c)+1);
				}
				si++;
			}
			if(count==0) {
				ll.add(si);
				ans++;
			}
			ei++;
		}
		return ll;
	}

}