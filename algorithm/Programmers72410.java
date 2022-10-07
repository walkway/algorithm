/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/72410
 * 신규 아이디 추천
 */
class Programmers72410 {
    public static void main(String[] args) {
        System.out.println(solution("=.="));
    }

    public static String solution(String new_id) {
        String answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^-_.a-z0-9]", "");
        answer = answer.replaceAll("[.]{2,}", ".");
        if (answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }

        if (answer.isEmpty()) {
            answer = "a";
        }

        if (answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
        }

        if (answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }

        if (answer.length() <= 2) {
            char last = answer.charAt(answer.length() - 1);
            while (answer.length() != 3) {
                answer = answer + last;
            }
        }

        return answer;
    }

}