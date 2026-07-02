class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int numsLength = nums.length;
        int sum = 0,i;
        double maxSum = Integer.MIN_VALUE;
        for(i=0;i<k;i++){
            sum = sum+nums[i];
        }
        double avg = (double)sum/k;
        maxSum = Math.max(maxSum,avg);
        for(i=k;i<numsLength;i++){
            sum = sum+nums[i]-nums[i-k];
            avg = (double)sum/k;
            maxSum=Math.max(maxSum,avg);
        }
        return maxSum;
    }
}