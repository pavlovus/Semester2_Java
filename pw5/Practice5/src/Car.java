public class Car {
    private String color;
    private int horsePowers;
    private int numberOfWheels;
    private String gearBox;
    private Engine engine;
    private Wheel[] wheels;

    public Car(String color, int horsePowers, int numberOfWheels, String gearBox, String fuelType) {
        this.color = color;
        this.horsePowers = horsePowers;
        this.numberOfWheels = numberOfWheels;
        this.gearBox = gearBox;
        this.engine = new Engine(fuelType, 10);  // Default fuel type and horsepower from Car
        this.wheels = new Wheel[numberOfWheels];  // Array to store wheels
        for (int i = 0; i < numberOfWheels; i++) {
            wheels[i] = new Wheel(32);  // Default pressure of 32 PSI for all wheels
        }
    }
    public Car (String color, int horsePowers, int numberOfWheels, String fuelType) {
        this.color = color;
        this.horsePowers = horsePowers;
        this.numberOfWheels = numberOfWheels;
        this.gearBox = "Автомат";
        this.engine = new Engine(fuelType, 10);  // Default fuel type and horsepower from Car
        this.wheels = new Wheel[numberOfWheels];  // Array to store wheels
        for (int i = 0; i < numberOfWheels; i++) {
            wheels[i] = new Wheel(32);  // Default pressure of 32 PSI for all wheels
        }
    }
    public Car (String color, int horsePowers, String fuelType) {
        this.color = color;
        this.horsePowers = horsePowers;
        this.numberOfWheels = 4;
        this.gearBox = "Автомат";
        this.engine = new Engine(fuelType, 10);  // Default fuel type and horsepower from Car
        this.wheels = new Wheel[numberOfWheels];  // Array to store wheels
        for (int i = 0; i < numberOfWheels; i++) {
            wheels[i] = new Wheel(32);  // Default pressure of 32 PSI for all wheels
        }
    }
    public Car (int horsePowers, int numberOfWheels, String fuelType) {
        this.horsePowers = horsePowers;
        this.numberOfWheels = numberOfWheels;
        this.color = "Невідомий";
        this.gearBox = "Автомат";
        this.engine = new Engine("Gasoline", horsePowers);  // Default fuel type and horsepower from Car
        this.wheels = new Wheel[numberOfWheels];  // Array to store wheels
        for (int i = 0; i < numberOfWheels; i++) {
            wheels[i] = new Wheel(32);  // Default pressure of 32 PSI for all wheels
        }
    }
    public Car (int numberOfWheels, String color, String fuelType) {
        this.color = color;
        this.numberOfWheels = numberOfWheels;
        this.horsePowers = 100;
        this.gearBox = "Автомат";
        this.engine = new Engine(fuelType, 10);  // Default fuel type and horsepower from Car
        this.wheels = new Wheel[numberOfWheels];  // Array to store wheels
        for (int i = 0; i < numberOfWheels; i++) {
            wheels[i] = new Wheel(32);  // Default pressure of 32 PSI for all wheels
        }
    }
    public Car (String color, String fuelType) {
        this.color = color;
        this.horsePowers = 100;
        this.numberOfWheels = 4;
        this.gearBox = "Автомат";
        this.engine = new Engine(fuelType, 10);  // Default fuel type and horsepower from Car
        this.wheels = new Wheel[numberOfWheels];  // Array to store wheels
        for (int i = 0; i < numberOfWheels; i++) {
            wheels[i] = new Wheel(32);  // Default pressure of 32 PSI for all wheels
        }
    }

    public Car(String color, int horsePowers, int numberOfWheels, String gearType, Engine engine, String fuelType) {
        this.color = color;
        this.horsePowers = horsePowers;
        this.numberOfWheels = numberOfWheels;
        this.wheels = new Wheel[numberOfWheels];  // Array to store wheels
        for (int i = 0; i < numberOfWheels; i++) {
            wheels[i] = new Wheel(32);  // Default pressure of 32 PSI for all wheels
        }
        this.gearBox = gearType;
        this.engine = new Engine(fuelType, 10);
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getHorsePowers() {
        return horsePowers;
    }
    public void setHorsePowers(int horsePowers) {
        this.horsePowers = horsePowers;
    }
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
    public String getGearBox() {
        return gearBox;
    }
    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }
    public String toString() {
        return "Машина, колір " + color + ", кількість колес - " + numberOfWheels + ", кількість кінських сил - " + horsePowers + ", коробка передач - " + gearBox + ", двигун: " + engine.toString();
    }
}
