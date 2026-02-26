public class Lion extends Animal {
    public Lion(String name) {
        super(name);
    }

    @Override
    public void showBehavior() {
        System.out.println(getName() + " реве в вольєрі.");
    }
}
