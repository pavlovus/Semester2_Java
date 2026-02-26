public class Sto implements CarService{
    public void service(Car car) {
        car.repair();
        System.out.println("Repairing your car");
    }
}
