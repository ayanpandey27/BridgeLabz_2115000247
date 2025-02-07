class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Animal makes a sound");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " - Name: " + name + ", Age: " + age;
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Bark! Bark!");
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }
}

class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Chirp! Chirp!");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal[] animals = {
            new Dog("Buddy", 3),
            new Cat("Whiskers", 2),
            new Bird("Tweety", 1)
        };

        for (Animal animal : animals) {
            System.out.println(animal);
            animal.makeSound();
            System.out.println();
        }
    }
}
