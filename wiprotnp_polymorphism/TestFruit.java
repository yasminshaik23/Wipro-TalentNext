public class TestFruit {
    public static void main(String[] args) {
        Apple apple = new Apple("Apple", "Sweet", "Medium");
        Orange orange = new Orange("Orange", "Sour", "Medium");
        apple.eat();
        orange.eat();
    }
}