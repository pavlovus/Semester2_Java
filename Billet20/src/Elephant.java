public class Elephant extends Animal {
    public Elephant(String name) {
        super(name);
    }

    @Override
    public void showBehavior() {
        System.out.println(getName() + " махає своїм хоботом.");
    }
}
