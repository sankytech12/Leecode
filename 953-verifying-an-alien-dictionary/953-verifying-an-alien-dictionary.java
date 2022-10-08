class Solution {
        HashMap<Character,Integer> map=new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        int c=-1;
        for(int i=0;i<words.length-1;i++){
          //  System.out.println(0);
           if(bigger(words[i],words[i+1])){
               return false;
           }
        }
        return true;
    }
    public boolean bigger(String a,String b){
        int n=a.length(),m=b.length();
        for(int i=0;i<n && i<m ;i++){
            if(a.charAt(i)!=b.charAt(i)){
               return map.get(a.charAt(i))>map.get(b.charAt(i));
            }
        }
        return n>m;
    }
}