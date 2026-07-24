import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    // Map customer id -> CheckInInfo
    private Map<Integer, CheckInInfo> checkInMap;
    // Map route ("startStation->endStation") -> RouteStats
    private Map<String, RouteStats> travelMap;

    private static class CheckInInfo {
        String stationName;
        int checkInTime;

        CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    private static class RouteStats {
        double totalTime = 0;
        int totalTrips = 0;
    }

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkIn = checkInMap.remove(id);
        String routeKey = checkIn.stationName + "->" + stationName;

        RouteStats stats = travelMap.computeIfAbsent(routeKey, k -> new RouteStats());
        stats.totalTime += (t - checkIn.checkInTime);
        stats.totalTrips += 1;
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteStats stats = travelMap.get(routeKey);
        return stats.totalTime / stats.totalTrips;
    }
}
