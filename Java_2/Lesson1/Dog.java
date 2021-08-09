public class Dog implements Participant{
    public boolean lost;
    private final int runLimit;
    private final int jumpLimit;

    public Dog(int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    public boolean getStatus() {return this.lost;}

    public void run(Track track) {
        if (track.length <= runLimit) {
            System.out.printf("Dog overcame an obstacle - %s\n", track);
        } else {
            System.out.printf("Dog did't overcame an ostacle - %s\n", track);
            lost = true;
        }
    }

    @Override
    public void jump(Wall wall) {
        if (wall.height <= jumpLimit) {
            System.out.printf("Dog overcame an obstacle - $s\n", wall);
        } else {
            System.out.printf("Dog did't overcame an obstacle %s\n", wall);
            lost = true;
        }
    }
}
