class Solution {
    public boolean Palindrome(String s)
    {
        int start=0,end=s.length()-1;
        while(start<=end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
               return false;
            }
            start++;
            end--;
        }
       return true;
      
    }
    public String shortestPalindrome(String s)
    {
       if(s.length()==1)
         return s;
       int end=1;
       for(int i=s.length();i>=0;i--)
       {
        if(Palindrome(s.substring(0,i)))
        {
          end=i;
          break;
        }
       }
       String extra=new StringBuilder(s.substring(end)).reverse().toString();
       return extra+s;

    }
}