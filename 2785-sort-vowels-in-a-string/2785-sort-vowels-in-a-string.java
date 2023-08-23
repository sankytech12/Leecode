class Solution {
    public String sortVowels(String s) {
        return solve(s);
    }
     private static String solve(String s) {
        char []ch=s.toCharArray();
        int vcount=0;
        for(char c:ch){
            if(isVolwel(c)){
                vcount++;
            }
        }
        int k=0;
        char []vowel=new char[vcount];
        for(char c:ch){
            if(isVolwel(c)){
                vowel[k++]=c;
            }
        }
        Arrays.sort(vowel);
        k=0;
        for (int i = 0; i < ch.length; i++) {
            if(isVolwel(ch[i])){
                ch[i]=vowel[k++];
            }
        }
        return String.valueOf(ch);
    }

    private static boolean isVolwel(char c) {

        return c=='A' || c=='E' || c=='I' || c=='O' || c=='U' || c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }
}