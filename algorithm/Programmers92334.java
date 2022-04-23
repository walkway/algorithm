import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/92334
 * 신고 결과 받기
 */
class Programmers92334 {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> indexByUser = new HashMap<>();
        Map<String, Set<String>> reportByUser = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            indexByUser.put(id, i);
            reportByUser.put(id, new HashSet<>());
        }

        for (String info : report) {
            String[] ids = info.split(" ");
            String from = ids[0];
            String to = ids[1];
            Set<String> reportedUsers = reportByUser.get(to);
            reportedUsers.add(from);
        }

        int[] result = new int[id_list.length];
        for (String id : id_list) {
            Set<String> receiverIds = reportByUser.get(id);
            if (receiverIds.size() >= k) {
                for (String receiverId : receiverIds) {
                    result[indexByUser.get(receiverId)]++;
                }
            }
        }

        return result;
    }
}