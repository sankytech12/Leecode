class Solution {
    public List<String> topKFrequent(String[] arr, int k) {
       HashMap<String,Integer> map=new HashMap<String, Integer>();
		for (int i = 0; i < arr.length; i++) {
			
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		PriorityQueue<Map.Entry<String, Integer>> pq=new PriorityQueue<Map.Entry<String,Integer>>(
				(a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());
		for(Map.Entry<String, Integer> en:map.entrySet()) {
			pq.offer(en);
			if(pq.size()>k) {
				pq.poll();
			}
		}
		List<String> ll=new ArrayList<String>();
		while(!pq.isEmpty()) {
			ll.add(0,pq.poll().getKey());		
			}

		return ll;
    }
}