import java.util.*;

/**
 * https://leetcode.com/problems/repeated-dna-sequences/
 * Repeated DNA Sequences
 */
class Leetcode187 {

    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }

        return new ArrayList<>(repeated);
    }

}