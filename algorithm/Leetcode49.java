import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 * Group Anagrams
 */
class Leetcode49 {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] elements = str.toCharArray();
            Arrays.sort(elements);
            String key = String.valueOf(elements);
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(str);
        }

        return new ArrayList<>(groups.values());
    }
}
