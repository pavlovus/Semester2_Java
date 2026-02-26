public class Bicycle extends Vehicle {
    public Bicycle(String name) {
        super(name);
    }

    @Override
    public void crossIntersection(){
        System.out.println("Bicycle" + getName() + " is crossing the intersection on a bike lane.");
    }
}
