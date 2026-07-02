class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        long target=(long)k*threshold;
        long sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        int count=(target<=sum)?1:0;
        for(int i=k;i<arr.length;i++){
            sum += arr[i]-arr[i-k];
            if(target<=sum){
                count++;
            }
        }
        return count;
    }
}     