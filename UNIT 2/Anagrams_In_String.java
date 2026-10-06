import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] windowCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = p.length();

        for (int i = 0; i < windowSize; i++) {
            windowCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, windowCount)) {
            result.add(0);
        }

        for (int i = windowSize; i < s.length(); i++) {

            windowCount[s.charAt(i) - 'a']++;

            windowCount[s.charAt(i - windowSize) - 'a']--;

            if (Arrays.equals(pCount, windowCount)) {
                result.add(i - windowSize + 1);
            }
        }

        return result;
    }
}