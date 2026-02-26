/*Практичне завдання №6, Вус Павло, ІПЗ-1
 Переробити ієрархію класів car з попереднього практичного так, щоб показати потужність поліморфізму.

Написати клас тестер.
* */
public class CarsUse {
    public static void main(String[] args) {
        Engine skodaEngine = new Engine("Бензин", 150);
        Engine vwEngine = new Engine("Дизель", 180);
        Engine newEngine = new Engine("Дизель", 160);
        SkodaOctavia skoda = new SkodaOctavia("Червоний", 250, 4, "Автомат", skodaEngine, "Дизель", "Купе");
        VolkswagenPassat passat = new VolkswagenPassat("Синій", 300,4, "Механіка", vwEngine, "Бензин");

        System.out.println(skoda);
        System.out.println(passat);
        System.out.println();
        skoda.changeSomething(newEngine);
        passat.changeSomething("Чорний");
        System.out.println();
        skoda.drive();
        passat.drive();
    }
}
