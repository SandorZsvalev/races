package participants;

import race.Participant;
import race.Raceable;

public abstract class Cat extends Participant {

   private static final int MINIMAL_STEP = 1;
   private static final int SPEED_COEFFICIENT = 3;

    public Cat(String name, int speed, int age) {
        super(name, speed, age,MINIMAL_STEP,SPEED_COEFFICIENT);
    }

}
