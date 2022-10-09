class Solution {
    public List<Integer> majorityElement(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
       // System.out.print(map);
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        for(int it:map.keySet()){
            if(map.get(it)>n/3){
                ans.add(it);
            }
        }

        return ans;
    }
}