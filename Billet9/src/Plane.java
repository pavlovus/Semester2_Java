public class Plane extends Aircraft{
    public Plane(String name, int maxSpeed){
        super(name, maxSpeed);
    }

    @Override
    public void takeOff(){
        System.out.println("Plane " + getName() + " is taking off from runway");
    }
    @Override
    public void land(){
        System.out.println("Plane " + getName() + " is landing on runway");
    }
}