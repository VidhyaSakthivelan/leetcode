class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        if (n > m) return false;

        int[] count = new int[26];

        
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0, right = 0, need = n;

        while (right < m) {
            
            if (count[s2.charAt(right) - 'a'] > 0) {
                need--;
            }
            count[s2.charAt(right) - 'a']--;
            right++;

            
            if (need == 0) {
                return true;
            }

            
            if (right - left == n) {
                if (count[s2.charAt(left) - 'a'] >= 0) {
                    need++;
                }
                count[s2.charAt(left) - 'a']++;
                left++;
            }
        }

        return false;
    }
}