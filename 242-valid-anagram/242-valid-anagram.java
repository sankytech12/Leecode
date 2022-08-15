class Solution {
    public boolean isAnagram(String s, String t) {
        String a=generate(s);
        String b=generate(t);
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                return false;
            }
        }
        return true;
    }
    public String generate(String s){
        int frq[]=new int[26];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            frq[ch-'a']=frq[ch-'a']+1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<frq.length;i++){
            sb.append(frq[i]);
        }
        return sb.toString();
    }
}