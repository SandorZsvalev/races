package race;

import java.util.Random;

public abstract class Participant implements Runnable {

    protected  long startTime;
    protected  long finishTime;

    private String name;
    private int speed;
    private int age;
    private int startPosition;
    private int currentPosition;
    private int distance;

    private int timeScore;
    private Random random = new Random();
    private int MINIMAL_STEP;
    private int SPEED_COEFFICIENT;


    public Participant(String name, int speed, int age, int MINIMAL_STEP, int SPEED_COEFFICIENT) {
        this.name = name;
        this.speed = speed;
        this.age = age;
        this.MINIMAL_STEP = MINIMAL_STEP;
        this.SPEED_COEFFICIENT = SPEED_COEFFICIENT;
    }

    public int getTimeScore() {
        return timeScore;
    }

    public void setTimeScore(int timeScore) {
        this.timeScore = timeScore;
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

    public int getAge() {
        return age;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        System.out.println("Побежал "+getName()+" в потоке "+Thread.currentThread().getName());
        while (RaceInThreads.raceIsOn){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int distanceForTurn = makeTurn(speed,age);
            setDistance(getDistance()+distanceForTurn);
 //           System.out.println(getName()+" cделал шаг, пройденная дистанция: "+getDistance());
            synchronized (this){
                checkTheResult(getDistance());
            }
        }
        finishTime = System.currentTimeMillis();
        setTimeScore(timeResult(startTime,finishTime));
    }

    private void checkTheResult(int currentDistance){
        if (currentDistance >= RaceInThreads.LAP) {
            System.out.println("Бегун "+getName()+" добежал до финала и закончил гонку, пробежав "+getDistance());
            RaceInThreads.raceIsOn = false;
        }
    }

    private int makeTurn(int speed, int age) {
        int randomSpeed = speed + random.nextInt(-SPEED_COEFFICIENT, SPEED_COEFFICIENT);
        int turnDistance = (int) (randomSpeed * (double) this.SPEED_COEFFICIENT / age);
        if (turnDistance > 0) {
            return turnDistance;
        } else {
            return this.MINIMAL_STEP;
        }
    }

    private int timeResult(long startTime, long finishTime){
        return (int) (finishTime-startTime);
    }



}
