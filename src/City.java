import java.util.ArrayList;
import java.util.List;

public class City {

    private final String name;
    private final List<Road> roadConnections = new ArrayList<>();

    public City(final String name) {
        this.name = name;
    }

    public void addRoadConnection(final Road to) {
        roadConnections.add(to);
    }

    public List<Road> getRoadConnections() {
        return roadConnections;
    }

    public String getName() {
        return name;
    }
}
