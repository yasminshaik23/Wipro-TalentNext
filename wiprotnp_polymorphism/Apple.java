class Apple extends Fruit {
    public Apple(String name, String taste, String size) {
        super(name, taste, size);
    }
    @Override
    public void eat() {
        System.out.println(getName() + " tastes Sweet");
    }
}