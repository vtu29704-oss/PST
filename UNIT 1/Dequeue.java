import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = in.nextInt();
        int m = in.nextInt();

        int maxUnique = 0;

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            // Add new element to deque
            deque.addLast(num);

            // Update frequency
            map.put(num, map.getOrDefault(num, 0) + 1);

            // Remove the oldest element if window size exceeds m
            if (deque.size() > m) {
                int removed = deque.removeFirst();

                if (map.get(removed) == 1) {
                    map.remove(removed);
                } else {
                    map.put(removed, map.get(removed) - 1);
                }
            }

            // Update maximum unique count when window size is m
            if (deque.size() == m) {
                maxUnique = Math.max(maxUnique, map.size());
            }
        }

        System.out.println(maxUnique);

        in.close();
    }
}