class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 ||(x!=0 && x%10==0))
          return false;

        int reverse_num=0;
        while(x>reverse_num)
        {
            reverse_num=reverse_num*10+x%10;
            x=x/10;

        }

        if(reverse_num==x || reverse_num/10==x)
           return true;
        else
          return false;       
    }
}