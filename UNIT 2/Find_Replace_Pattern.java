import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> result = new ArrayList<>();

        for (String word : words) {

            if (matches(word, pattern)) {
                result.add(word);
            }
        }

        return result;
    }

    private boolean matches(String word, String pattern) {

        char[] patternToWord = new char[26];
        char[] wordToPattern = new char[26];

        Arrays.fill(patternToWord, '#');
        Arrays.fill(wordToPattern, '#');

        for (int i = 0; i < pattern.length(); i++) {

            char p = pattern.charAt(i);
            char w = word.charAt(i);

            if (patternToWord[p - 'a'] != '#') {
                if (patternToWord[p - 'a'] != w) {
                    return false;
                }
            }

            if (wordToPattern[w - 'a'] != '#') {
                if (wordToPattern[w - 'a'] != p) {
                    return false;
                }
            }

            patternToWord[p - 'a'] = w;
            wordToPattern[w - 'a'] = p;
        }

        return true;
    }
}