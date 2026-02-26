public class StoFactory implements CarServiceFactory{
    public CarService getCarService() { return new Sto(); }
}
