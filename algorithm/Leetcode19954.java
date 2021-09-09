/**
 * https://leetcode.com/problems/minimum-garden-perimeter-to-collect-enough-apples/
 * Minimum Garden Perimeter to Collect Enough Apples
 */
class Leetcode19954 {
    public long minimumPerimeter(long neededApples) {
        long side = 0;
        while (true) {
            long apples = getApples(side);
            if (apples >= neededApples) {
                return side * 4;
            }

            side += 2;
        }
    }

    public long getApples(long l) {
        return l * (l / 2 + 1) * (l + 1);
    }
}