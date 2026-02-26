public class PetTest {

    static abstract class Pet {
        String name;
        int satisfaction;

        public Pet(String name) {
            this.name = name;
            this.satisfaction = 50;
        }

        abstract void makeSound();

        void play() {
            satisfaction += 10;
            System.out.println(name + " грається. Задоволення: " + satisfaction);
        }

        void feed() {
            satisfaction += 5;
            System.out.println(name + " поїв. Задоволення: " + satisfaction);
        }
    }

    static class Cat extends Pet {
        public Cat(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            System.out.println(name + " каже: Мяу!");
        }
    }

    static class Dog extends Pet {
        public Dog(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            System.out.println(name + " каже: Гав!");
        }
    }

    static class Owner {
        String name;

        public Owner(String name) {
            this.name = name;
        }

        void care(Pet pet) {
            System.out.println(name + " доглядає за " + pet.name);
            pet.feed();
            pet.play();
        }
    }
    static class Apartment {
        Owner owner;
        Pet[] pets;

        public Apartment(Owner owner, Pet[] pets) {
            this.owner = owner;
            this.pets = pets;
        }

        void liveOneDay() {
            for (Pet pet : pets) {
                owner.care(pet);
                pet.makeSound();
            }
        }
    }

    public static void main(String[] args) {
        Owner owner = new Owner("Анна");

        Pet[] pets = {
                new Cat("Мурчик"),
                new Dog("Рекс")
        };

        Apartment apartment = new Apartment(owner, pets);
        apartment.liveOneDay();
    }
}

