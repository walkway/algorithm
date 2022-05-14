/**
 * https://programmers.co.kr/learn/courses/30/lessons/12953
 * N개의 최소공배수
 */
class Programmers12953 {

    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 0; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    public static int lcm(int num1, int num2) {
        return (num1 * num2) / gcd(num1, num2);
    }

    public static int gcd(int num1, int num2) {
        return num2 == 0 ? num1 : gcd(num2, num1 % num2);
    }
}