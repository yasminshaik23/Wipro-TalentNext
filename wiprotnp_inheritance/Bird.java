class Animal {
    public void eat() {
        System.out.println("Animal is eating");
    }
    public void sleep() {
        System.out.println("Animal is sleeping");
    }
}
public class Bird extends Animal {
    @Override
    public void eat() {
        System.out.println("Bird is eating");
    }
    @Override
    public void sleep() {
        System.out.println("Bird is sleeping");
    }
    public void fly() {
        System.out.println("Bird is flying");
    }
    public static void main(String[] args) {
        Animal a = new Animal();
        a.eat();
        a.sleep();
        System.out.println();
        Bird b = new Bird();
        b.eat();
        b.sleep();
        b.fly();
    }
}