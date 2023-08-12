class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st=new Stack<>();
        int []ans=new int[temp.length];
        st.push(0);
        for(int i=1;i<temp.length;i++){
            while(!st.isEmpty() && temp[st.peek()]<temp[i]){
                int ind=st.pop();
                ans[ind]=i-ind;
            }
            st.push(i);
        }
        return ans;
    }
}