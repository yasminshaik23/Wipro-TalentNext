class Box {
    int width;
    int height;
    int depth;
    Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    int volume() {
        return width * height * depth;
    }
    public static void main(String[] args) {

        Box b = new Box(10, 5, 2);

        System.out.println("Volume = " + b.volume());
    }
}