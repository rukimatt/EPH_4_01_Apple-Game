package my_project.model;

public class Apple extends Fruit {
    public Apple(double x, double y, int offset, Player[] players) {
        super (x, y, offset, "src/main/resources/graphic/apple.png", players);
    }
}