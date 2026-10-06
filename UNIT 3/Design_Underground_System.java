import java.util.*;

class UndergroundSystem {

    HashMap<Integer, Pair> checkIn;
    HashMap<String, int[]> trips;

    public UndergroundSystem() {
        checkIn = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Pair(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair p = checkIn.get(id);

        String key = p.station + "->" + stationName;

        if (!trips.containsKey(key)) {
            trips.put(key, new int[]{0, 0});
        }

        trips.get(key)[0] += t - p.time;
        trips.get(key)[1]++;

        checkIn.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;

        int[] data = trips.get(key);

        return (double) data[0] / data[1];
    }

    class Pair {
        String station;
        int time;

        Pair(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }
}
