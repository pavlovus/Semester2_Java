public class ShopAssistant {
    String name;
    public ShopAssistant(String name) {
        this.name = name;
    }

    public void recommendProduct(Product product) {
        System.out.println("Recommended product: ");
        product.display();
    }
}