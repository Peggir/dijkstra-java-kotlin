import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NavigationMap {

    private static final int INFINITE = Integer.MAX_VALUE;

    private final List<City> cities = new ArrayList<>();
    private final Map<City, Integer> d = new HashMap<>(); // <City, Its distance from start node>
    private final Map<City, City> pi = new HashMap<>(); // <City, Its predecessor in path>

    public void printShortestRoutes(final City start) {
        // Initialize
        cities.forEach(c -> {
            d.put(c, INFINITE);
            pi.put(c, null);
        });

        // Set distance from start node to 0
        d.put(start, 0);

        final List<City> S = new ArrayList<>();
        final List<City> Q = new ArrayList<>(cities);

        while (!Q.isEmpty()) {
            final City u = extractMin(Q);
            Q.remove(u);
            S.add(u);

            for (final Road v : u.getRoadConnections()) {
                // Relaxation
                if (d.get(v.getTo()) > d.get(u) + v.getDistance()) {
                    d.put(v.getTo(), d.get(u) + v.getDistance());
                    pi.put(v.getTo(), u);
                }
            }
        }

        prettyPrintShortestRoutes(start);
    }

    public void addCity(final City city) {
        cities.add(city);
    }

    private void prettyPrintShortestRoutes(final City source) {
        for (final City c : cities) {
            String road = c.getName();
            City p = pi.get(c);
            while (p != null) {
                road = p.getName() + " -> " + road;
                p = pi.get(p);
            }

            System.out.println("Distance from " + source.getName() + " to "
                    + c.getName() + ": " + d.get(c) + " km");
            System.out.println("Route: " + road + "\n");
        }
    }

    private City extractMin(final List<City> Q) {
        City min = Q.get(0);

        for (final City c : Q) {
            if (d.get(c) < d.get(min)) {
                min = c;
            }
        }

        return min;
    }
}
