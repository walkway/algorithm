import java.util.*;

/**
 * https://www.programmers.co.kr/learn/courses/30/lessons/138476
 * 귤 고르기
 */
class Programmers138476 {

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> countBySize = new HashMap<>();
        for (int size : tangerine) {
            countBySize.put(size, countBySize.getOrDefault(size, 0) + 1);
        }

        int answer = 0;
        // value sorted
        List<Integer> sizes = new ArrayList<>(countBySize.keySet());
        sizes.sort((o1, o2) -> countBySize.get(o2) - countBySize.get(o1));
        for (Integer size : sizes) {
            k -= countBySize.get(size);
            answer++;
            if (k <= 0) {
                break;
            }
        }

        return answer;
    }

}