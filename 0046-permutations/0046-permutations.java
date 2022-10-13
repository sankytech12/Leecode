class Solution {
    public List<List<Integer>> permute(int[] arr) {
       List<List<Integer>> ll=new ArrayList<>();
        solve(arr,ll,new ArrayList<>());
        return ll;

    }

    private static void solve(int[] arr,List<List<Integer>> ll,List<Integer> o) {
        if(o.size()==arr.length){
            ll.add(new ArrayList<>(o));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(o.contains(arr[i])) continue;
            o.add(arr[i]);
            solve(arr, ll, o);
            o.remove(o.size()-1);
        }
    }
}