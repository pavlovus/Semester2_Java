public class Bus extends Car {
    private int passengerCapacity;  // кількість пасажирів

    public Bus(String color, int horsePowers, int numberOfWheels, String gearBox, int passengerCapacity, String fuelType) {
        super(color, horsePowers, numberOfWheels, gearBox);
        this.passengerCapacity = passengerCapacity;
    }

    public Bus(String color, int horsePowers, int numberOfWheels, int passengerCapacity, String fuelType) {
        super(color, horsePowers, numberOfWheels, fuelType);
        this.passengerCapacity = passengerCapacity;
    }

    public Bus(int numberOfWheels, int passengerCapacity, String fuelType) {
        super(100, numberOfWheels, fuelType);  // дефолтні значення для кінських сил та кольору
        this.passengerCapacity = passengerCapacity;
    }

    public Bus(String color, int horsePowers, int numberOfWheels, String gearType, Engine engine, String fuelType) {
        super(color, horsePowers, numberOfWheels, gearType, engine, fuelType);
        this.passengerCapacity = 8;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
    @Override
    public void drive(){
        System.out.println("Ви їдете автобусом!");
    }
    @Override
    public String toString() {
        return "Автобус, колір " + getColor() + ", кількість колес - " + getNumberOfWheels() + ", кількість кінських сил - " + getHorsePowers() + ", коробка передач - " + getGearBox() +
                ", пасажирська місткість - " + passengerCapacity;
    }
}