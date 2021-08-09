public class Lesson1 {
    public static void main(String[] args) {
        Obstacle [] obstacles = {
                new Track(50),
                new Wall(6),
                new Track(100),
                new Wall(7),
                new Track(300),
                new Wall(20),
                new Track(40),
                new Wall(7)
        };

        Participant[] participants = {
                new Human(40, 3),
                new Human(55,20),
                new Dog(99,6),
                new Dog(200,9),
                new Cat(200, 19),
                new Cat(400,40),
                new Robot(30,6),
                new Robot(50,10)
        };

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!participant.getStatus()) {
                    participant.overcomeObstacle(obstacle);
                }
            }

            System.out.print("\n");
        }
    }
}
