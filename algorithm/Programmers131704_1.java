import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/131704
 * 택배상자
 */
class Programmers131704_1 {
    public static void main(String args[]) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}));
    }

    public static int solution(int[] order) {
        int answer = 0;
        Stack<Integer> sub = new Stack<>();
        int containerBoxNumber = 1;
        int sortedIndex = 0;
        while (true) {
            if (!sub.isEmpty() && order[sortedIndex] == sub.peek()) {
                answer++;
                sortedIndex++;
                sub.pop();

                continue;
            }

            if (containerBoxNumber > order.length) {
                break;
            }

            if (order[sortedIndex] == containerBoxNumber) {
                answer++;

                sortedIndex++;
                containerBoxNumber++;

                continue;
            }

            sub.push(containerBoxNumber);
            containerBoxNumber++;
        }

        return answer;
    }

}