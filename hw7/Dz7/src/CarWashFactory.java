public class CarWashFactory  implements CarServiceFactory{
    public CarService getCarService() { return new CarWash(); }
}
