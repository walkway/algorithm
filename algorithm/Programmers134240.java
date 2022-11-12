/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/134240
 * 푸드 파이트 대회
 */
class Programmers134240 {
    public static void main(String args[]) {
        System.out.println(solution(new int[] {1, 7, 1, 2}));
    }

    public static String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            for (int j = 0; j < count; j++) {
                answer.append(i);
            }
        }

        String first = answer.toString();
        String second = answer.reverse().toString();

        return first + "0" + second;
    }
}