class Solution {
    public int longestOnes(int[] nums, int k) {
        int numsLength=nums.length;
        int i =0,j=0,maxLen=0;
        for(i=0;i<numsLength;i++)
        {
            int tempK=k;
            for(j=i;j<numsLength;j++)
            {
                if(nums[j]==0)
                {
                    if(tempK==0)
                    {
                        break;
                    }
                    tempK--;
                }
                maxLen = Math.max(maxLen,j-i+1);
            }
        }
        return maxLen;
    }
}