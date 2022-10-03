class Solution {
public:
    int maximumRobots(vector<int>& chargeTimes, vector<int>& runningCosts, long long budget) {
        deque<int> dq;
        //int ei=0,si=0,ans=0;
         long long sum=0;
        int ans=0;
        int j=0;
        for(int i=0;i<chargeTimes.size();i++){
            sum+=runningCosts[i];
            while(!dq.empty() && dq.back()<chargeTimes[i]){
                dq.pop_back();
            }
             dq.push_back(chargeTimes[i]);
            long long tot=sum*(i-j+1)+dq.front();
            while(tot>budget){
                sum-=runningCosts[j];
                if(dq.front()==chargeTimes[j]){
                    dq.pop_front();
                }
                tot=sum*(i-j+1)+dq.front();
                j++;
            }
            ans=max(ans,i-j+1);
        }
        // while(ei<chargeTimes.size()){
        //     sum+=runningCosts[ei];
        //     while(!dq.empty() && dq.back()<chargeTimes[ei]){
        //         dq.pop_back();
        //     }
        //     dq.push_back(chargeTimes[ei]);
        //     long long tot=sum*(ei-si+1)+dq.front();
        //     while(tot>budget){
        //         sum-=runningCosts[si];
        //         if(dq.front()==runningCosts[si]){
        //             dq.pop_front();
        //         }
        //         tot=sum*(ei-si+1)+dq.front();
        //         si++;
        //     }
        //     ans=max(ans,ei-si+1);
        //     ei++;
        // }
        
        return ans;
    }
};