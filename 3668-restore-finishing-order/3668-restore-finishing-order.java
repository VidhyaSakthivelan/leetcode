import java.util.*;

class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> set = new HashSet<>();

        for (int f : friends) {
            set.add(f);
        }

        int[] ans = new int[friends.length];
        int index = 0;

        for (int x : order) {
            if (set.contains(x)) {
                ans[index++] = x;
            }
        }

        return ans;
    }
}