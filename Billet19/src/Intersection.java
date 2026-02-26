public class Intersection {
    private String location;

    public Intersection(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void handleCrossing(Vehicle vehicle) {
        System.out.println("At the intersection " + getLocation());
        vehicle.crossIntersection();
    }
}
