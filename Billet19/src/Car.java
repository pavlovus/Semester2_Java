public class Car extends Vehicle {
    public Car(String name) {
        super(name);
    }

    @Override
    public void crossIntersection(){
        System.out.println("Car" + getName() + " is crossing the intersection on a car lane.");
    }
}
