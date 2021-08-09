public class Track implements Obstacle{
    public final int length;

    public Track (int length) {
        this.length = length;
    }

    public String toString() {
        return String.format("Track with length: %d", length);
    }
}

