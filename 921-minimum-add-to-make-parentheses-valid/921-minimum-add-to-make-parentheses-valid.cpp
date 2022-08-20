class Solution {
public:
    int minAddToMakeValid(string s) {
        stack<char> st;
        int counter = 0;
        for(char ch : s){
            if(ch == ')'){
                if(st.empty())  counter++;
                else    st.pop();
            }
            else    st.push(ch);
        }
        counter += st.size();
        return counter;
    }
};