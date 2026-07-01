class Solution 
{
    public boolean findDuplicates(int [] hash)
    {
        int i,count = 0;
        for(i=0;i<26;i++)
        {
            if(hash[i]>1)
            {
                return false;
            }
        }
        return true;
    }
    public int countGoodSubstrings(String s)
     {
        int sLength = s.length();
        int i,k=3,count =0;
        int [] hash = new int [26];
        if(sLength<3)
        {
            return 0;
        }
        for(i=0;i<k;i++)
        {
            int index = s.charAt(i)-'a';
            hash[index]++;
        }
        boolean ans=findDuplicates(hash);
        if(ans==true)
        {
            count++;
        }
        for(i=k;i<sLength;i++)
        {
            int prevIndex = s.charAt(i-k)-'a';
            hash[prevIndex]--;
            int currentIndex = s.charAt(i)-'a';
            hash[currentIndex]++;
            ans=findDuplicates(hash);
            if(ans==true)
            {
                count++;
            }
        }
        return count;
        }
}