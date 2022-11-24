class Solution {
    public int myAtoi(String s) {
        int total=0;
        int sign=1;
        int idx=0;
        while(idx<s.length() && s.charAt(idx)==' '){
            idx++;
        }
        if(idx==s.length()) return 0;
        if(idx<s.length() && s.charAt(idx)=='+' || s.charAt(idx)=='-'){
            sign=s.charAt(idx)=='-'?-1:1;
            idx++;
        }
        while(idx<s.length()){
            int digit=s.charAt(idx)-'0';
            if(digit<0 || digit>9) break;
            if(Integer.MAX_VALUE/10<total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE%10 < digit){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            total=10*total+digit;
            idx++;
        }
        return total*sign;
    }
}