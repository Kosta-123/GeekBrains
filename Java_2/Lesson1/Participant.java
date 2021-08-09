public interface Participant {

    default void overcomeObstacle(Obstacle obstacle) {
        if (obstacle instanceof Wall) {
            Wall wall = (Wall) obstacle;
            this.jump(wall);
        } else if (obstacle instanceof Track) {
            Track track = (Track) obstacle;
            this.run(track);
        }
    }
    boolean getStatus();
    void jump(Wall wall);
    void run(Track track);
}
