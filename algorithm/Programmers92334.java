import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/92334
 * 신고 결과 받기
 */
class Programmers92334 {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> userByIndex = new HashMap<>();
        Map<String, Set<String>> userByReport = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            userByIndex.put(id, i);
            userByReport.put(id, new HashSet<>());
        }

        for (String info : report) {
            String[] ids = info.split(" ");
            String from = ids[0];
            String to = ids[1];
            userByReport.get(to).add(from);
        }

        int[] result = new int[id_list.length];
        for (String id : id_list) {
            Set<String> receiverIds = userByReport.get(id);
            if (receiverIds.size() >= k) {
                for (String receiverId : receiverIds) {
                    result[userByIndex.get(receiverId)]++;
                }
            }
        }

        return result;
    }
}