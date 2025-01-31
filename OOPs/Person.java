public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [Name=" + name + ", Age=" + age + "]";
    }

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        System.out.println("Original Person: " + person1);

        Person person2 = new Person(person1);
        System.out.println("Copied Person: " + person2);
    }
}

