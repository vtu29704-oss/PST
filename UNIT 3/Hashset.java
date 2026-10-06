import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < t; i++) {
            String a = s.next();
            String b = s.next();

            set.add(a + " " + b);

            System.out.println(set.size());
        }

        s.close();
    }
}