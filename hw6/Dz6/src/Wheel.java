public class Wheel {
    private int pressure;

    public Wheel(int pressure) {
        this.pressure = pressure;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public String toString() {
        return "Це колесо, тиск в ньому - " + pressure + "атмосфери";
    }
}
