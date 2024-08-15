class Solution {
    public String reorganizeString(String s) {
        
       
        int ar[] = new int[26]; 
        int n = s.length(); 
        int cnt = n; 
        
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i); 
            ar[ch - 'a']++; 
        }
        
        
        char ans[] = new char[n]; 
        int max = Integer.MIN_VALUE;
        int letter = -1;

        for (int i = 0; i < 26; i++) {
            if (max < ar[i]) {
                max = ar[i];
                letter = i;
            }  
        }
        
       
        if (ar[letter] > (n + 1) / 2) {
            return "";
        }
        
        
        int ind = 0; 
        while (ar[letter]-- > 0) {
            ans[ind] = (char)(letter + 'a');
            ind += 2; 
        }
        
        
        for (int i = 0; i < 26; i++) {
            while (ar[i]-- > 0) {
                if (ind >= n) {
                    ind = 1; 
                }
                ans[ind] = (char)(i + 'a'); 
                ind += 2; 
            }
        }
        
        
        return String.valueOf(ans);
    }
}