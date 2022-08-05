/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 * Maximum Product of Word Lengths
 */
class Leetcode318 {

    public static int maxProduct(String[] words) {
        int[] value = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            value[i] = 0;
            for (int j = 0; j < temp.length(); j++) {
                value[i] |= 1 << (temp.charAt(j) - 'a');
            }
        }

        int maxProduct = 0;
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
                    maxProduct = words[i].length() * words[j].length();
            }
        return maxProduct;
    }

}