/**
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 *
 * 큰 수 만들기
 */
class Programmers42883 {
    public static void main(String args[]) {
        System.out.println(solution("1231234", 3));
    }

    public static String solution(String number, int k) {
        StringBuilder stringBuilder = new StringBuilder();
        int resultLength = number.length() - k;
        int index = 0;
        for(int i = 0; i < resultLength; i++) {
            char max = 0;
            for(int j = index; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    index = j + 1;
                }
            }

            stringBuilder.append(max);
        }

        return stringBuilder.toString();
    }
}