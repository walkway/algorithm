import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sums-divisible-by-k/
 * Subarray Sums Divisible by K
 */
class Leetcode974 {

    public int subarraysDivByK(int[] A, int K) {
        int count = 0;

        Map<Integer, Integer> frequency = new HashMap<>();

        int accumulateSum = 0;
        for (int num : A) {
            accumulateSum += num;
            while (accumulateSum < 0) {
                accumulateSum += K;
            }

            int remainder = (accumulateSum % K + K) % K;
            frequency.put(remainder, frequency.getOrDefault(remainder, 0) + 1);
        }

        for (int freq : frequency.values()) {
            if (freq > 1) {
                count += freq * (freq - 1) / 2;
            }
        }

        count += frequency.getOrDefault(0, 0);

        return count;
    }

}