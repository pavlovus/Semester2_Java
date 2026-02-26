public class Tester {
    public static void main(String[] args) {
        Product cd= new CD("Classic Movie", 12);
        Product bluRay = new BluRay("Action Movie", 19);

        ShopAssistant seller = new ShopAssistant("Pavlo Vus");

        seller.recommendProduct(cd);
        seller.recommendProduct(bluRay);

        Customer customer = new Customer("Vus Pavlo");

        customer.buyProduct(bluRay);
    }
}

