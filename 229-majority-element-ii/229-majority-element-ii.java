class Solution {
    public List<Integer> majorityElement(int[] arr) {
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<arr.length;i++){
//             map.put(arr[i],map.getOrDefault(arr[i],0)+1);
//         }
//        // System.out.print(map);
//         List<Integer> ans=new ArrayList<>();
//         int n=arr.length;
//         for(int it:map.keySet()){
//             if(map.get(it)>n/3){
//                 ans.add(it);
//             }
//         }

//         return ans;
        return solve(arr);
    }
    public List<Integer> solve(int []arr){
        int e1=0,e2=0,c1=0,c2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==e1){
                c1++;
            }else if(arr[i]==e2){
                c2++;
            }else if(c1==0){
                e1=arr[i];
                c1++;
            }else if(c2==0){
                e2=arr[i];
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==e1) c1++;
            else if(arr[i]==e2) c2++;
        }
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        if(c1>n/3){
            ans.add(e1);
        }
        if(c2>n/3){
            ans.add(e2);
        }
        return ans;
    }
}