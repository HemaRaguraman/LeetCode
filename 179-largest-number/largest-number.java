class Solution {
    public String largestNumber(int[] nums) {
        String s="",s1="";int temp=0;
        
       for(int i=0;i<nums.length-1;i++)
       {
         for(int j=i+1;j<nums.length;j++)
         {
           s=s+nums[i]+nums[j];
           s1=s1+nums[j]+nums[i];
          
           if(s.compareTo(s1)<0)
            {
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
            s="";
            s1="";
         }
       }
       String str="";
       for(int i=0;i<nums.length;i++)
       {
           str=str+nums[i];
       }
        if(nums[0]==0)
        {
            return "0";
        }
       return str;
    }
}