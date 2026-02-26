public class VolkswagenPassat extends Bus {

    public VolkswagenPassat(String color, int horsePowers, int numberOfWheels, String gearBox, int passengerCapacity, String fuelType) {
        super(color, horsePowers, numberOfWheels, gearBox, passengerCapacity, fuelType);
    }

    public VolkswagenPassat(String color, int horsePowers, int numberOfWheels, int passengerCapacity, String fuelType) {
        super(color, horsePowers, numberOfWheels, passengerCapacity, fuelType);
    }

    public VolkswagenPassat(int numberOfWheels, int passengerCapacity, String fuelType) {
        super(numberOfWheels, passengerCapacity, fuelType);
    }

    public VolkswagenPassat(String color, int horsePowers,  int numberOfWheels, String gearType, Engine engine, String fuelType) {
        super(color, horsePowers, numberOfWheels, gearType, engine, fuelType);
    }

    @Override
    public String toString() {
        return "Volkswagen Passat, " + super.toString();
    }
}
