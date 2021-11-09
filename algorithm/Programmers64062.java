/**
 * https://programmers.co.kr/learn/courses/30/lessons/64062
 * 징검다리 건너기
 */
class Programmers64062 {
    public int solution(int[] stones, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int stone : stones) {
            max = Math.max(max, stone);
            min = Math.min(min, stone);
        }

        return binarySearch(stones, k, min, max);
    }

    private int binarySearch(int[] stones, int k, int left, int right) {
        if (left == right) {
            return left;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canCross(stones, k, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }

    private boolean canCross(int[] stones, int k, int friends) {
        int passCount = 0;

        for (int stone : stones) {
            if (stone - friends < 0) {
                passCount++;
            } else {
                passCount = 0;
            }

            if (passCount == k) {
                return false;
            }
        }

        return true;
    }
}