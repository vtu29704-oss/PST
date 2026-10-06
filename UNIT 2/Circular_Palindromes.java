import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.joining;

class Result {

    public static List<Integer> circularPalindromes(String s) {

        int n = s.length();
        String t = s + s;
        List<Integer> ans = new ArrayList<>();

        for (int start = 0; start < n; start++) {

            int best = 1;

            for (int center = start; center < start + n; center++) {

              
                int l = center, r = center;

                while (l >= start && r < start + n &&
                       t.charAt(l) == t.charAt(r)) {
                    best = Math.max(best, r - l + 1);
                    l--;
                    r++;
                }


                l = center;
                r = center + 1;

                while (l >= start && r < start + n &&
                       t.charAt(l) == t.charAt(r)) {
                    best = Math.max(best, r - l + 1);
                    l--;
                    r++;
                }
            }

            ans.add(best);
        }

        return ans;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        List<Integer> result =
            Result.circularPalindromes(s);

        System.out.println(
            result.stream()
                  .map(String::valueOf)
                  .collect(joining("\n"))
        );
    }
}