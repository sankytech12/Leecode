class Solution {
    class Pair{
        int frq;
        char ch;
        Pair(int frq,char ch){
            this.frq=frq;
            this.ch=ch;
        }
    }
    public String reorganizeString(String s) {
        int []f=new int[26];
        for(int i=0;i<s.length();i++){
            f[s.charAt(i)-'a']++;
            if(f[s.charAt(i)-'a']>(s.length()+1)/2) return "";
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.frq-a.frq);
        for(int i=0;i<26;i++){
            if(f[i]!=0){
                pq.offer(new Pair(f[i],(char)(i+'a')));
            }
        }
        StringBuilder ans=new StringBuilder();
        while(pq.size()>=2){
            Pair p1=pq.poll();
            Pair p2=pq.poll();
            ans.append(p1.ch);
            ans.append(p2.ch);
            if(p1.frq>1){
                pq.offer(new Pair(p1.frq-1,p1.ch));
            }
            if(p2.frq>1){
                pq.offer(new Pair(p2.frq-1,p2.ch));
            }
        }
        if(!pq.isEmpty()){
            ans.append(pq.poll().ch);
        }
        return ans.toString();
    }
}