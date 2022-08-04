package race;

public interface Raceable {

    int makeTurn(int speed, int age);

    void setStartPosition(int startPosition);

    int getStartPosition();

    void setCurrentPosition(int currentPosition);

    int getCurrentPosition();

    int getSpeed();

    int getAge();

    void setDistance(int distance);

    int getDistance();

    String getName();



}
