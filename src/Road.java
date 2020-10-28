public class Road {

    private final City to;
    private final int distance;

    public Road(final City to, final int distance) {
        this.to = to;
        this.distance = distance;
    }

    public City getTo() {
        return to;
    }

    public int getDistance() {
        return distance;
    }
}
