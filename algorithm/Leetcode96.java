/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * Unique Binary Search Trees
 */
class Leetcode96 {
    /*
    root node 기준, left * right
    n = 4
    root 1 left[], right[2, 3, 4] = ans(3)
    root 2 left[1], right[3, 4] = ans(1) * ans(2)
    root 3 left[1, 2], right[3, 4] = ans(2) * ans(1)
    root 4 left[1, 2, 3], right[] = ans(3)
     */
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int node = 2; node <= n; node++) {
            for (int root = 1; root <= node; root++) {
                int left = root - 1;
                int right = node - root;
                dp[node] += dp[left] * dp[right];
            }
        }

        return dp[n];
    }
}
