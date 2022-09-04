class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
		for(char c:s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		List<Map.Entry<Character, Integer>> ll=new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
		Collections.sort(ll,new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue()-o1.getValue();
			}
		});
		StringBuilder sb=new StringBuilder();
		for(Map.Entry es:ll) {
			
			for (int i = 0; i<(int) es.getValue(); i++) {
				sb.append(es.getKey());
			}
		}
		return sb.toString();
    }
}