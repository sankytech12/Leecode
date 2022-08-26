class Solution {
    public boolean isScramble(String a, String b) {
        
    	
		if(a.length()!=b.length()) {
			return false;
		}
		if(a.length()==0) {
			return true;
		}
		return isPossible(a,b);
	}
	static HashMap<String, Boolean> map=new HashMap<String, Boolean>();
	private static boolean isPossible(String a, String b) {
		// TODO Auto-generated method stub
		if(a.compareTo(b)==0) {
			return true;
		}
		if(a.length()<=1) {
			return false;
		}
		StringBuilder key=new StringBuilder();
		key.append(a);
		key.append(" ");
		key.append(b);
		if(map.containsKey(key.toString())) {
			return map.get(key.toString());
		}
		int n=a.length();
		boolean flag=false;
		for (int i = 1; i <=n-1; i++) {
			boolean first=isPossible(a.substring(0,i), b.substring(n-i, n))&&isPossible(a.substring(i, n), b.substring(0,n-i));
			boolean second=isPossible(a.substring(0,i), b.substring(0,i))&&isPossible(a.substring(i,n),b.substring(i, n));
			if(first==true||second==true) {
				flag=true;
				break;
			}
			
		}
		map.put(key.toString(), flag);
		return flag;
	}

}