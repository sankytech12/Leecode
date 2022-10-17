class Solution {
    public boolean canCross(int[] stones) {
      return solve(stones);
    }
    
    private static boolean solve(int []stones){
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(stones[0]).add(1);
        for (int j = 0; j < stones.length; j++) {
            int currStone=stones[j];
            HashSet<Integer> hs=map.get(currStone);
            for (int jump : hs) {
                int rechedStone=currStone+jump;
                if(rechedStone==stones[stones.length-1]) return true;
                if(map.containsKey(rechedStone)){
                    if(jump>1) map.get(rechedStone).add(jump-1);
                    map.get(rechedStone).add(jump);
                    map.get(rechedStone).add(jump+1);
                }
            }
        }
        return false;
    }
}