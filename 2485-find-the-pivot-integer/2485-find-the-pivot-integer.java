class Solution {
    public int pivotInteger(int n) {
        int total=n*(n+1)/2;
        int leftsum=0;
        for(int i =1;i<=n;i++){
            leftsum+=i;
            if(leftsum==total-leftsum+i){
                return i;
            }
        }
        return -1;
    }
}