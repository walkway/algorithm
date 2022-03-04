/**
 * https://leetcode.com/problems/koko-eating-bananas/
 * Koko Eating Bananas
 */
class Leetcode875 {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int middle = (left + right) / 2;
            int hour = 0;

            for (int pile : piles) {
                hour += Math.ceil((double) pile / middle);
            }

            if (hour <= h) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return right;
    }
}
