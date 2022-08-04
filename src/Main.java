import participants.*;
import race.Race;
import race.Raceable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Raceable one = new AndalusianHorse("One",16,7);
        Raceable two = new AkhaltekeHorse("Two",17,10);
        Raceable three = new ArabianHorse("Three",13,3);
        Raceable four = new AndalusianHorse("Four",10,2);
        Raceable five = new AkhaltekeHorse("Five",20,5);
        Raceable six = new ArabianHorse("Six",18,12);
        Raceable seven = new RussianCat("Seven",10,3);
        Raceable eight = new PersianCat("Eight",12,14);
        Raceable nine = new BritishCat("Nine",8,3);
        Raceable ten = new RussianCat("Ten",12,9);
        Raceable eleven = new PersianCat("Eleven",5,8);
        Raceable twelve = new BritishCat("Twelve",11,2);


        List <Raceable> runners = new ArrayList<>();
        runners.add(one);
        runners.add(two);
        runners.add(three);
        runners.add(four);
        runners.add(five);
        runners.add(six);
        runners.add(seven);
        runners.add(eight);
        runners.add(nine);
        runners.add(ten);
        runners.add(eleven);
        runners.add(twelve);

        Race race = new Race(runners);

        race.run();


    }



}
