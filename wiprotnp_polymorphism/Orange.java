class Orange extends Fruit {
    public Orange(String name, String taste, String size) {
        super(name, taste, size);
    }
    @Override
    public void eat() {
        System.out.println(getName() + " tastes Sour");
    }
}