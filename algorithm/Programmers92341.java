import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/92341
 * 주차 요금 계산
 */
class Programmers92341 {

    public int[] solution(int[] fees, String[] records) {
        Map<String, List<String>> inOutRecords = new HashMap<>();
        for (String record : records) {
            String[] inOutRecord = record.split(" ");
            String carNumber = inOutRecord[1];
            List<String> times = inOutRecords.getOrDefault(carNumber, new ArrayList<>());
            times.add(inOutRecord[0]);
            inOutRecords.put(inOutRecord[1], times);
        }

        Map<String, Integer> accumulatedTimes = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : inOutRecords.entrySet()) {
            String carNumber = entry.getKey();
            List<String> times = entry.getValue();
            if (times.size() % 2 == 0) {
                for (int i = times.size() - 1; i > 0; i = i - 2) {
                    int differenceMinutes = getMinutes(times.get(i)) - getMinutes(times.get(i - 1));
                    accumulatedTimes.put(carNumber, accumulatedTimes.getOrDefault(carNumber, 0) + differenceMinutes);
                }
            } else {
                int lastDifferenceMinutes = getMinutes("23:59") - getMinutes(times.get(times.size() - 1));
                accumulatedTimes.put(carNumber, lastDifferenceMinutes);
                for (int i = times.size() - 2; i > 0; i = i - 2) {
                    int differenceMinutes = getMinutes(times.get(i)) - getMinutes(times.get(i - 1));
                    accumulatedTimes.put(carNumber, accumulatedTimes.get(carNumber) + differenceMinutes);
                }
            }
        }

        List<String> carNumbers = new ArrayList<>(accumulatedTimes.keySet());
        Collections.sort(carNumbers);
        int[] answer = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            String carNumber = carNumbers.get(i);
            int calculated = accumulatedTimes.get(carNumber) - fees[0];
            answer[i] = calculated > 0 ? (int) (fees[1] + (Math.ceil((double) calculated / fees[2]) * fees[3])) : fees[1];
        }

        return answer;
    }

    public int getMinutes(String time) {
        String[] timeUnit = time.split(":");
        return Integer.parseInt(timeUnit[0]) * 60 + Integer.parseInt(timeUnit[1]);
    }
}