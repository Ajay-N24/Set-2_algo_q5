package fifth;

import java.util.HashMap;
import java.util.Map;

public class Fifth {

    // Memoization map to store results of substrings
    private static Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        String s = "ababc";
        System.out.println(maxOperations(s));  // Output: Maximum number of operations needed
    }

    public static int maxOperations(String s) {
        return helper(s);
    }

    private static int helper(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        int n = s.length();
        int maxOps = 1;  // At least one operation is needed if we delete the entire string

        // Try every possible i to delete
        for (int i = 1; i <= n / 2; i++) {
            if (canDelete(s, i)) {
                maxOps = Math.max(maxOps, 1 + helper(s.substring(i)));
            }
        }

        memo.put(s, maxOps);
        return maxOps;
    }

    public static boolean canDelete(String s, int i) {
        // Check if the first i characters match the following i characters
        return s.length() >= 2 * i && s.substring(0, i).equals(s.substring(i, 2 * i));
    }
}

