public class FactoryExampleUse {
    public static void main(String[] args) {
        Car car1 = new Car("Чорний", "Ланос", false, false);
        Car car2 = new Car("Коричневий", "Копійка", true, false);
        CarServiceFactory carWashFact = new CarWashFactory();
        CarServiceFactory carSTOFact = new StoFactory();
        CarService carWash = carWashFact.getCarService();
        CarService carSTO = carSTOFact.getCarService();
        carWash.service(car1);
        carSTO.service(car2);
        System.out.println(car1);
        System.out.println(car2);
    }
}
