import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // Initialize with sum 0 appearing once
        
        for (int num : nums) {
            sum += num;
            // If (sum - k) exists in map, we found subarrays with sum = k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            // Add current sum to map
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}

// time O(N)
// space O(N)


//time O(N)
//space O(1)