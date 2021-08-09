public class Wall implements Obstacle {
    public final int height;

    public Wall(int height) {this.height = height;}

    public String toString() {return String.format("Wall with height: %d", height);
    }
}
