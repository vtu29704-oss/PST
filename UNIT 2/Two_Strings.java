import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static String twoStrings(String s1, String s2) {

        boolean[] present = new boolean[26];

        for (char c : s1.toCharArray()) {
            present[c - 'a'] = true;
        }

        for (char c : s2.toCharArray()) {
            if (present[c - 'a']) {
                return "YES";
            }
        }

        return "NO";
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
            new BufferedWriter(
                new FileWriter(System.getenv("OUTPUT_PATH"))
            );

        int q = Integer.parseInt(
            bufferedReader.readLine().trim()
        );

        IntStream.range(0, q).forEach(qItr -> {
            try {

                String s1 = bufferedReader.readLine();
                String s2 = bufferedReader.readLine();

                String result = Result.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}