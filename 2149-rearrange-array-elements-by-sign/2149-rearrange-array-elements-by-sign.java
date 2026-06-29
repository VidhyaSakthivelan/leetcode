class Solution 
{
    public int[] rearrangeArray(int[] nums)
     {
        int numsLength = nums.length;
        int i;
        int [] finalAns = new int[nums.length];
        int [] pos=new int [numsLength/2];
        int [] neg=new int [numsLength/2];
        int posIndex=0,negIndex=0;
        for(i=0;i<numsLength;i++)
        {
            if(nums[i]>0)
            {
            pos[posIndex]=nums[i];
            posIndex++;
            }
            else
            {
                neg[negIndex]=nums[i];
                negIndex++;
            }
        }
        int  finalAnsIndex = 0;
        for(i=0;i<numsLength/2;i++)
        {
            finalAns[finalAnsIndex] = pos[i];
            finalAns[finalAnsIndex+1] = neg [i];
            finalAnsIndex=finalAnsIndex+2;
        }
        return finalAns;
    }
}
//time:O(N+N/2)
//space:O(N)