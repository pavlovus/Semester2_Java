public class AirportUse {
    public static void main(String[] args) {
        Aircraft plane = new Plane("Boeing", 500);
        Aircraft helicopter = new Helicopter("Helicopter Cool", 300);

        Airport airport = new Airport("International Airport");

        airport.launchAircraft(plane);
        airport.receiveAircraft(plane);
        airport.launchAircraft(helicopter);
        airport.receiveAircraft(helicopter);
    }
}
