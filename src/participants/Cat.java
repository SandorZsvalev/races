package participants;

import race.Raceable;

import java.util.Random;

public abstract class Cat implements Raceable {
    private String name;
   private int speed;
   private int age;
   private int startPosition;
   private int currentPosition;
   private int distance;
   private Random random = new Random();
   private final int MINIMAL_STEP = 1;
    private final int SPEED_COEFFICIENT = 3;

    public Cat (String name, int speed, int age) {
        this.name = name;
        this.speed = speed;
        this.age = age;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int makeTurn(int speed, int age) {
        int randomSpeed = speed + random.nextInt(-SPEED_COEFFICIENT, SPEED_COEFFICIENT);
        int turnDistance = (int) (randomSpeed * (double) SPEED_COEFFICIENT / age);
        if (turnDistance > 0) {
            return turnDistance;
        } else {
            return MINIMAL_STEP;
        }
    }
}
