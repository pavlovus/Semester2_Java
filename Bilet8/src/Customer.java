public class Customer {
    String name;
    public Customer(String name) {
        this.name = name;
    }

    public void buyProduct(Product product) {
        System.out.println(name + " is buying the product: ");
        product.beBought();
    }
}
