import java.util.*;

class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));

        int count = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) count++;
            if (i >= k && set.contains(s.charAt(i - k))) count--;
            max = Math.max(max, count);
            if (max == k) return k;
        }
        return max;
    }
} 