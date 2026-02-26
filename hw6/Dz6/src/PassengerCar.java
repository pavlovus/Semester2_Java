public class PassengerCar extends Car {
    private String typeOfPassengerCar;

    public PassengerCar(String color, int horsePowers, int numberOfWheels, String gearBox, String fuelType) {
        super(color, horsePowers, numberOfWheels, gearBox);
        this.typeOfPassengerCar = fuelType;
    }

    public PassengerCar(String color, int horsePowers, int numberOfWheels, String fuelType) {
        super(color, horsePowers, numberOfWheels, fuelType);
        this.typeOfPassengerCar = fuelType;
    }

    public PassengerCar(int horsePowers,int numberOfWheels, String fuelType) {
        super(100, numberOfWheels, fuelType);  // дефолтні значення для кінських сил та кольору
        this.typeOfPassengerCar = fuelType;
    }

    public PassengerCar(String color, int horsePowers, int numberOfWheels, String gearType, Engine engine, String fuelType, String typeOfPassengerCar) {
        super(color, horsePowers, numberOfWheels, gearType, engine, fuelType);
        this.typeOfPassengerCar = typeOfPassengerCar;
    }

    public String getTypeOfPassengerCar() {
        return typeOfPassengerCar;
    }

    public void setTypeOfPassengerCar(String fuelType) {
        this.typeOfPassengerCar = fuelType;
    }
    @Override
    public void drive(){
        System.out.println("Ви їдете пасажирським автомобілем!");
    }
    @Override
    public String toString() {
        return "Легковий автомобіль, колір " + getColor() + ", кількість колес - " + getNumberOfWheels() + ", кількість кінських сил - " + getHorsePowers() + ", коробка передач - " + getGearBox() +
                 ", тип автомобілю - " + typeOfPassengerCar;
    }
}
