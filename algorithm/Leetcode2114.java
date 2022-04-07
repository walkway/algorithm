/**
 * https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 * Maximum Number of Words Found in Sentences
 */
class Leetcode2114 {

    public int mostWordsFound(String[] sentences) {
        int output = 0;
        for (int i = 0; i < sentences.length; i++) {
            String current[] = sentences[i].split(" ");
            output = Math.max(output, current.length);
        }

        return output;
    }

}
