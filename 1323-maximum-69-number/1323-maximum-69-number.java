class Solution {
    public int maximum69Number (int num) {  
        int div = 1;
        while (num / div >= 10) {
            div *= 10;
        }
        while (div > 0) {
            int digit = (num / div) % 10;

            if (digit == 6) {
                num = num + 3 * div;
                break;
            }
            div /= 10;
        }
        return num;
    }
}