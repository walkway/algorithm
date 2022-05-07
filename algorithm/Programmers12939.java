/**
 * https://programmers.co.kr/learn/courses/30/lessons/12939
 * 최댓값과 최솟값
 */
class Programmers12939 {

    public String solution(String s) {
        String[] numbers = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String number : numbers) {
            int converted = Integer.parseInt(number);
            if (converted < min) {
                min = converted;
            }
            if (converted > max) {
                max = converted;
            }
        }

        return min + " " + max;
    }
}