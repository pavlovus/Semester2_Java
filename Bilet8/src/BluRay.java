public class BluRay extends Product {
    public BluRay(String name, double price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.println("This is Blu-ray: " + getName() +" - " + getPrice() + " USD");
    }
    @Override
    public void beBought() {
        System.out.println("This is Blu-ray: " + getName() +" - " + getPrice() + " USD is bought");
    }
}
