public class App {

    public static void main(final String[] args) {
        final City amsterdam = new City("Amsterdam");
        final City hilversum = new City("Hilversum");
        final City utrecht = new City("Utrecht");
        final City ede = new City("Ede");
        final City tiel = new City("Tiel");
        final City arnhem = new City("Arnhem");

        amsterdam.addRoadConnection(new Road(hilversum, 34));
        amsterdam.addRoadConnection(new Road(utrecht, 43));
        hilversum.addRoadConnection(new Road(ede, 56));
        hilversum.addRoadConnection(new Road(tiel, 57));
        hilversum.addRoadConnection(new Road(utrecht, 20));
        utrecht.addRoadConnection(new Road(hilversum, 20));
        utrecht.addRoadConnection(new Road(tiel, 50));
        ede.addRoadConnection(new Road(arnhem, 20));
        tiel.addRoadConnection(new Road(ede, 37));

        final NavigationMap map = new NavigationMap();
        map.addCity(amsterdam);
        map.addCity(hilversum);
        map.addCity(utrecht);
        map.addCity(ede);
        map.addCity(tiel);
        map.addCity(arnhem);

        map.printShortestRoutes(amsterdam);
    }
}
