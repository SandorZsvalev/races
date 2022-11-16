package race;

import participants.Cat;
import participants.Horse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RaceInThreads {

    private final Random random = new Random();
    private List<Participant> runners;

    public static final int LAP = 300;
    public static boolean raceIsOn = true;
    private final Participant NOT_DEFINED = null;


    Comparator <Participant> comp = (o1, o2) -> -1*(o1.getDistance() - o2.getDistance());


    public RaceInThreads(List<Participant> runners) {
        this.runners = runners;
    }

    private void init() {
        for (Participant runner : runners) {
            int startNumber = random.nextInt(runners.size());
            runner.setStartPosition(startNumber);
        }
    }

    private void showAllDistancesAfterTurn () {
        for (Participant runner : runners) {
            System.out.print(" "+ runner.getDistance()+" ");
        }
        System.out.println("\n");
    }
    
    private void sortByResult (List<Participant> runners){
        runners.sort(comp);
        for (Participant runner : runners) {
             runner.setCurrentPosition(runners.indexOf(runner)+1);
            System.out.println("имя "+runner.getName()+
                    ", пройденная дистанция "+runner.getDistance()+
                    ", результат "+runner.getCurrentPosition()+
                    ", время "+runner.getTimeScore());
        }
    }
    
    private void printWinner(Participant runner){
        System.out.print("Гонка закончена. \nВ гонке победил "+runner.getName()+" ");
        System.out.println(", гонщик класса: "+runner.getClass());
        System.out.println("Стартовавший с позиции: "+runner.getStartPosition());
        System.out.println("Возраст: "+ runner.getAge());
        System.out.println("Скорость: "+runner.getSpeed()+"\n");
    }

    public void rating (){
        List <Participant> horses = new ArrayList<>();
        List <Participant> cats = new ArrayList<>();
        List <Participant> all = new ArrayList<>();

        for (Participant runner : runners) {
            if (runner instanceof Horse){
                horses.add(runner);
            }
            if (runner instanceof Cat) {
                cats.add(runner);
            }
            all.add(runner);
        }
        System.out.println("Рейтинг лошадей");
        sortByResult(horses);
        System.out.println("Рейтинг котов");
        sortByResult(cats);
        System.out.println("Общий рейтинг");
        sortByResult(all);

    }

//    public void runAll (){
//        init();
//        Partisipants winner = NOT_DEFINED;
//        while (raceIsOn){
//            winner = turn();
//            showAllDistancesAfterTurn();
//        }
//        if (winner != null) printWinner(winner);
//        sortByResult(runners);
//        System.out.println("\n");
//        rating();
//    }

}
