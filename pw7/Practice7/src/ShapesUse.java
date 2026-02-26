/*Практичне завдання №7, Вус Павло, ІПЗ-1
Написати свій приклад з використанням абстрактних класів і інтерфейсів.
* */
public class ShapesUse {
    public static void main(String[] args) {
        Triangle triangle = new Triangle("Чорний", 0, 0, 2, 2 , 1);
        Rectangle rect = new Rectangle("Білий", 3, 1,2 , 1);
        Circle circle = new Circle("Синій", 4, 2, 3);
        triangle.draw();
        rect.draw();
        circle.draw();
    }
}
