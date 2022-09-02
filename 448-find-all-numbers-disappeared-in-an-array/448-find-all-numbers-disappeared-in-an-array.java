class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
       List<Integer> ll=new ArrayList<Integer>();
		// HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		// for (int i = 1; i <=arr.length; i++) {
		// 	map.put(i, 0);
		// }
		// for (int i = 0; i < arr.length; i++) {
		// 	map.put(arr[i], map.get(arr[i])+1);
		// }		
		// for(int key:map.keySet()) {
		// 	if(map.get(key)==0) {
		// 		ll.add(key);
		// 	}
		// }
        int []frq=new int[arr.length+1];
		for (int i = 0; i < arr.length; i++) {
			frq[arr[i]]++;
		}
		for (int i = 1; i < frq.length; i++) {
			if(frq[i]==0) {
				ll.add(i);
			}
		}
		return ll;
    }
}