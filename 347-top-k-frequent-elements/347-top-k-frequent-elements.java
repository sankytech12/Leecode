class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        ArrayList<Integer> ll=new ArrayList<Integer>();
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i:arr) {
			map.put(i, map.getOrDefault(i, 0)+1);
		}
		PriorityQueue<Map.Entry<Integer, Integer>> pq=new PriorityQueue<Map.Entry<Integer,Integer>>((a,b) -> b.getValue()-a.getValue());
		for(Map.Entry en:map.entrySet()) {
			pq.add(en);
		}
		int []ans=new int[k];
		for (int i = 0; i < k; i++) {
			ans[i]=pq.poll().getKey();
		}
		return ans;
    }
}