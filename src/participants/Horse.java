package participants;

import race.Participant;
import race.Raceable;

public abstract class Horse extends Participant {

   private static final int MIN_STEP = 1;
   private static final int SP_COEFFICIENT = 5;


    public Horse(String name, int speed, int age) {
        super(name, speed, age, MIN_STEP, SP_COEFFICIENT);
    }

}
