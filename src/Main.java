import PS.PetrihoSiet;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        PetrihoSiet PS=new PetrihoSiet();
        List<String> places= new ArrayList<>();
        places.add("p1");
        places.add("p2");
        places.add("p3");
        System.out.println(places);
        List<String> transition= new ArrayList<>();
        transition.add("t0");
        transition.add("t1");
        transition.add("t2");
        transition.add("t3");
        System.out.println(transition);
        List<Integer> marking = new ArrayList<>();
        marking.add(1);
        marking.add(0);
        marking.add(0);
        System.out.println(marking);
        List<String> edge=new ArrayList<>(List.of("p1-t3","t3-p1","p1-t1","p1-t0","t3-p2","p2-t2","t1-p3","t2-p3","p3-t2","p3-t0"));
        System.out.println(edge);

        PS.createPS(edge,places,transition,marking);
        PS.startsTransition("t3");


    }
}
