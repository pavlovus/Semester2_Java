public class Helicopter extends Aircraft{
    public Helicopter(String name, int maxSpeed){
        super(name, maxSpeed);
    }

    @Override
    public void takeOff(){
        System.out.println("Helicopter " + getName() + " is taking off from runway");
    }
    @Override
    public void land(){
        System.out.println("Helicopter " + getName() + " is landing on runway");
    }
}
