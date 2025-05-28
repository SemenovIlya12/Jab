public class Human {
    private String name;
    private int height;

    public Human(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return this.name + ", Height: " + this.height;
    }
}
