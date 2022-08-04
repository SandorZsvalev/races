package race;

import participants.Cat;
import participants.Horse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Race {

    private final Random random = new Random();
    private List<Raceable> runners;
    private final int LAP = 100;
    private boolean raceIsOn = true;
    private final Raceable NOT_DEFINED = null;

    private class Comp implements Comparator <Raceable> {
        @Override
        public int compare(Raceable o1, Raceable o2) {
            return -1*(o1.getDistance() - o2.getDistance());
        }
    }
    Comp comp = new Comp();


    public Race(List<Raceable> runners) {
        this.runners = runners;
    }

    private void init() {
        for (Raceable runner : runners) {
            int startNumber = random.nextInt(runners.size());
            runner.setStartPosition(startNumber);
        }
    }

    private Raceable turn(){
        for (Raceable runner : runners) {
            int distanceForTurn = runner.makeTurn(runner.getSpeed(),runner.getAge());
            runner.setDistance(runner.getDistance()+distanceForTurn);
            if (runner.getDistance() >= LAP) {
                raceIsOn = false;
                return runner;
            }
        }
        return NOT_DEFINED;
    }

    private void showAllDistancesAfterTurn () {
        for (Raceable runner : runners) {
            System.out.print(" "+ runner.getDistance()+" ");
        }
        System.out.println("\n");
    }
    
    private void sortByResult (List<Raceable> runners){
        runners.sort(comp);
        for (Raceable runner : runners) {
             runner.setCurrentPosition(runners.indexOf(runner)+1);
            System.out.println("имя "+runner.getName()+" пройденная дистанция "+runner.getDistance()+" результат "+runner.getCurrentPosition());
        }
    }
    
    private void printWinner(Raceable runner){
        System.out.print("Гонка закончена. \nВ гонке победил "+runner.getName()+" ");
        System.out.println(", гонщик класса: "+runner.getClass());
        System.out.println("Стартовавший с позиции: "+runner.getStartPosition());
        System.out.println("Возраст: "+ runner.getAge());
        System.out.println("Скорость: "+runner.getSpeed()+"\n");
    }

    private void rating (){
        List <Raceable> horses = new ArrayList<>();
        List <Raceable> cats = new ArrayList<>();

        for (Raceable runner : runners) {
            if (runner instanceof Horse){
                horses.add(runner);
            }
            if (runner instanceof Cat) {
                cats.add(runner);
            }
        }
        System.out.println("Рейтинг лошадей");
        sortByResult(horses);
        System.out.println("Рейтинг котов");
        sortByResult(cats);

    }

    public void run (){
        init();
        Raceable winner = NOT_DEFINED;
        while (raceIsOn){
            winner = turn();
            showAllDistancesAfterTurn();
        }
        if (winner != null) printWinner(winner);
        sortByResult(runners);
        System.out.println("\n");
        rating();
    }

}
