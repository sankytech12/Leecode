public class BipartitePair{
		int vtx;
		int d;
		public BipartitePair() {
			// TODO Auto-generated constructor stub
		}
		public BipartitePair(int vtx,int d) {
			// TODO Auto-generated constructor stub
			this.vtx=vtx;
			this.d=d;
		}
	}
	class Solution {
	    public boolean isBipartite(int[][] graph) {
	        HashMap<Integer, HashMap<Integer, Integer>> map=new HashMap<>();
	        for (int i = 0; i < graph.length; i++) {
				map.put(i, new HashMap<>());
			}
	        for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph[i].length; j++) {
					map.get(i).put(graph[i][j], 0);
				}
			}
	        return Bipartite(map);
	    }
	    public boolean Bipartite(HashMap<Integer, HashMap<Integer, Integer>> map) {
	    	LinkedList<BipartitePair> qq=new LinkedList<>();
	    	HashMap<Integer,Integer> visited=new HashMap<Integer, Integer>();
	    	for(int src:map.keySet()) {
	    		if(visited.containsKey(src)) {
	    		continue;
	    		}
	    		BipartitePair bp=new BipartitePair(src,0);
	    		qq.add(bp);
	    		while(!qq.isEmpty()) {
	    			BipartitePair r=qq.remove();
	    			if(visited.containsKey(r.vtx)&&r.d!=visited.get(r.vtx)) {
	    				return false;
	    			}
	    			visited.put(r.vtx, r.d);
	    			for(int nbrs:map.get(r.vtx).keySet()) {
	    				if(!visited.containsKey(nbrs)) {
	    					BipartitePair a=new BipartitePair(nbrs,r.d+1);
	    					qq.add(a);
	    				}
	    			}
	    		}
	    		
	    	}
	    	return true;
	    }
	}