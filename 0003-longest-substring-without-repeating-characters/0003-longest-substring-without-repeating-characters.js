/**
 * @param {string} s
 * @return {number}
};
 */
var lengthOfLongestSubstring = function(s) {
    let ei=0;
    let si=0;
    let frq=new Array(256).fill(0);
    let ans=0;
    while(ei<s.length){
        let c=s.charCodeAt(ei);
        frq[c]++;
        while(frq[c]>1){
            let ch=s.charCodeAt(si);
            frq[ch]--;
            si++;
        }
        ans=Math.max(ans,ei-si+1);
        ei++;
    }
    return ans;
};