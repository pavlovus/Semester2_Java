class CarWash implements CarService {
    public void service(Car car) {
        car.clean();
        System.out.println("Washing your car");
    }
}