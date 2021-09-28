import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/description/
 * Restore IP Addressesø
 */
class Leetcode93 {
    public List<String> restoreIpAddresses(String s) {
        return separate(s, 3);
    }

    private List<String> separate(String s, int point) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < s.length() && i < 4; i++) {
            String top = s.substring(0, i);
            String bottom = s.substring(i);
            if (check(top) && (point > 1 || check(bottom))) {
                List<String> last = point > 1 ? separate(bottom, point - 1) : Collections.singletonList(bottom);
                for (String l : last) {
                    result.add(top + "." + l);
                }
            }
        }

        return result;
    }

    private boolean check(String s) {
        if (s.charAt(0) == '0' && s.length() != 1) {
            return false;
        }

        return s.length() <= 3 && Integer.parseInt(s) <= 255;
    }
}