/**
 * https://leetcode.com/problems/trapping-rain-water/
 * Trapping Rain Water
 */
class Leetcode42 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {
            if (leftMax < rightMax) {
                result += leftMax - height[left];
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                result += rightMax - height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }

        return result;
    }
}