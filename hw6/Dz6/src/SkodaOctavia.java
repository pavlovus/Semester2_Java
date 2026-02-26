public class SkodaOctavia extends PassengerCar {
    public SkodaOctavia(String color, int horsePowers, int numberOfWheels, String gearBox, String fuelType) {
        super(color, horsePowers, numberOfWheels, gearBox, fuelType);
    }
    public SkodaOctavia(String color, int horsePowers, int numberOfWheels, String fuelType) {
        super(color, horsePowers, numberOfWheels, fuelType);
    }
    public SkodaOctavia(int horsePowers, int numberOfWheels, String fuelType) {
        super(horsePowers, numberOfWheels, fuelType);  // дефолтні значення для кінських сил та кольору
    }
    public SkodaOctavia(String color, int horsePowers, int numberOfWheels, String gearType, Engine engine, String fuelType, String typeOfPassengerCar) {
        super(color, horsePowers, numberOfWheels, gearType, engine, fuelType, typeOfPassengerCar);
    }
    @Override
    public void drive(){
        System.out.println("Ви їдете Шкодою Октавія!");
    }
    @Override
    public String toString() {
        return "Skoda Octavia, " + super.toString();
    }
}