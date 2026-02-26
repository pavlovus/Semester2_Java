public class Engine {
    private String fuelType;
    private double fuelUse;

    public Engine(String fuelType, double fuelUse) {
        this.fuelType = fuelType;
        this.fuelUse = fuelUse;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public double getFuelUse() {
        return fuelUse;
    }

    public void setFuelUse(double fuelUse) {
        this.fuelUse = fuelUse;
    }

    @Override
    public String toString() {
        return "Це мотор, він використовує " + fuelType + ", споживання пального - " + fuelUse + "на 10 км";
    }
}
