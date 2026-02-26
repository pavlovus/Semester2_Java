public class Airport {
    private String airportName;

    public Airport(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void launchAircraft(Aircraft aircraft) {
        if (aircraft instanceof Plane) {
            System.out.println("The plane is launching from a long runway");
        } else if (aircraft instanceof Helicopter) {
            System.out.println("The helicopter is launching from a short runway");
        }

        aircraft.takeOff();
    }

    public void receiveAircraft(Aircraft aircraft) {
        if (aircraft instanceof Plane) {
            System.out.println("The plane is landing on a long runway");
        } else if (aircraft instanceof Helicopter) {
            System.out.println("The helicopter is landing on a short runway");
        }

        aircraft.land();
    }
}
