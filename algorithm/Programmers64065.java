import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64065
 * 튜플
 */
class Programmers64065 {

    public static void main(String args[]) {
        System.out.println(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));
    }

    public static int[] solution(String s) {
        Map<Integer, Integer> tupleNumbers = new HashMap<>();
        String temp = s.replace("{", "").replace("}", "");
        String[] numbers = temp.split(",");
        for (String number : numbers) {
            Integer key = Integer.parseInt(number);
            tupleNumbers.put(key, tupleNumbers.getOrDefault(key, 0) + 1);
        }

        List<Integer> result = tupleNumbers.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> Integer.compare(o2, o1)))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }

}