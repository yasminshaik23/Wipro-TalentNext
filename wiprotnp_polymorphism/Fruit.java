class Fruit {
    private String name;
    private String taste;
    private String size;
    public Fruit(String name, String taste, String size) {
        this.name = name;
        this.taste = taste;
        this.size = size;
    }
    public String getName() {
        return name;
    }
    public String getTaste() {
        return taste;
    }
    public String getSize() {
        return size;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTaste(String taste) {
        this.taste = taste;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void eat() {
        System.out.println(name + " tastes " + taste);
    }
}