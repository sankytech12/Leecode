class Solution {
    public int partitionString(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int count = 0;
        
        while (i < arr.length) {
            int j = i + 1;
            boolean[] seen = new boolean[26]; // To track characters seen in the current substring
            
            seen[arr[i] - 'a'] = true; // Mark the first character as seen
            
            while (j < arr.length && !seen[arr[j] - 'a']) {
                seen[arr[j] - 'a'] = true; // Mark new characters as seen
                j++;
            }
            
            count++; // Increment the count for each substring
            i = j; // Move i to the next substring
        }
        
        return count;

    }
}