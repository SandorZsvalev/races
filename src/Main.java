import participants.*;
import race.Participant;
import race.RaceInThreads;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Participant one = new AndalusianHorse("One",16,7);
        Participant two = new AkhaltekeHorse("Two",17,10);
        Participant three = new ArabianHorse("Three",13,3);
        Participant four = new AndalusianHorse("Four",10,2);
        Participant five = new AkhaltekeHorse("Five",20,5);
        Participant six = new ArabianHorse("Six",18,12);
        Participant seven = new RussianCat("Seven",10,3);
        Participant eight = new PersianCat("Eight",12,14);
        Participant nine = new BritishCat("Nine",8,3);
        Participant ten = new RussianCat("Ten",12,9);
        Participant eleven = new PersianCat("Eleven",5,8);
        Participant twelve = new BritishCat("Twelve",11,2);


//        List <Raceable> runners = new ArrayList<>();
        List <Participant> runners = new ArrayList<>();
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

//        Race race = new Race(runners);
//        race.runAll();

        RaceInThreads raceInThreads = new RaceInThreads(runners);
        for (Participant runner : runners) {
            new Thread(runner).start();
        }



        Thread.sleep(1000);
        System.out.println("end of race");
        raceInThreads.rating();
    }


}
