//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        return solve(wordList,startWord,targetWord);
    }
    static class Pair{
		String word;
		int level;
		Pair(String word,int level){
			this.level=level;
			this.word=word;
		}
	}
	private static int solve(String[] wordList, String start, String end) {
		// TODO Auto-generated method stub
		HashSet<String> hs=new HashSet<>();
		LinkedList<Pair> qq=new LinkedList<>();
		qq.add(new Pair(start, 1));
		for (int i = 0; i < wordList.length; i++) {
			hs.add(wordList[i]);
		}
		hs.remove(start);
		while(!qq.isEmpty()) {
			Pair rv=qq.remove();
			if(rv.word.equals(end)) return rv.level;
			for (int i = 0; i < rv.word.length(); i++) {
				for(char ch='a';ch<='z';ch++) {
					char rep[]=rv.word.toCharArray();
					rep[i]=ch;
					String newS=new String(rep);
					if(hs.contains(newS)) {
						hs.remove(newS);
						qq.add(new Pair(newS, rv.level+1));
					}
				}
			}
		}
		return 0;
	}

}