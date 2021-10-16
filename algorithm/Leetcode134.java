/**
 * https://leetcode.com/problems/gas-station/
 * Gas Station
 */
class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int maxLeft = 0;
        int left = 0;
        int startIndex = 0;
        for (int i = n - 1; i >= 0; i--) {
            left += gas[i] - cost[i];
            if (left > maxLeft) {
                maxLeft = left;
                startIndex = i;
            }
        }
        return left < 0 ? -1 : startIndex;
    }
}

