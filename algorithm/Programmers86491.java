/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 * 최소직사각형
 */
class Programmers86491 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
    }

    public static int solution(int[][] sizes) {
        int cardWidth = 0;
        int cardHeight = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                cardWidth = Math.max(cardWidth, sizes[i][0]);
                cardHeight = Math.max(cardHeight, sizes[i][1]);
            } else {
                cardWidth = Math.max(cardWidth, sizes[i][1]);
                cardHeight = Math.max(cardHeight, sizes[i][0]);
            }
        }

        return cardWidth * cardHeight;
    }

}