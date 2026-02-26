/*Практичне завдання №5, Вус Павло, ІПЗ-1
 Написати клас який на вхід отримує стрічку символів і зберігає її.

На запит користувача повертається закодована стрічка. В якості кодування стрічки можна взяти шифр Цезаря.

На запит користувача повертається розкодована стрічка.
* */
public class CarsUse {
    public static void main(String[] args) {
        Engine skodaEngine = new Engine("Бензин", 150);  // Бензиновий двигун, 150 кінських сил
        Engine vwEngine = new Engine("Дизель", 180);  // Дизельний двигун, 180 кінських сил

        SkodaOctavia skoda = new SkodaOctavia("Червоний", 250, 4, "Автомат", skodaEngine, "Дизель", "Купе");
        VolkswagenPassat passat = new VolkswagenPassat("Синій", 300,4, "Механіка", vwEngine, "Бензин");

        System.out.println(skoda);
        System.out.println(passat);
    }
}
