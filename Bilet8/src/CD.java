public class CD extends Product {
    public CD(String name, double price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.println("This is CD: " + getName() +" - " + getPrice() + " USD");
    }
    @Override
    public void beBought() {
        System.out.println("This is CD: " + getName() +" - " + getPrice() + " USD is bought");
    }
}
