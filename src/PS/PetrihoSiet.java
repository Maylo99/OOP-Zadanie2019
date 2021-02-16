package PS;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PetrihoSiet {
    private List<Integer> initialMarking;
    private Place availablePlaces;
    private Transition availableTransitions;
    private Edge availableEdges;

    public Edge getAvailableEdges() {
        return availableEdges;
    }

    public List<Integer> getInitialMarking() {
        return initialMarking;
    }

    public void createPS(List <String> edge,List <String> place,List <String> transition,List<Integer> marking)
    {
        availableEdges=new Edge(edge);
        availablePlaces=new Place(place);
        availableTransitions=new Transition(transition);
        initialMarking=marking;
    }

    public void consumerT(String ID){
        Map<String,Integer> consume=availableEdges.consumeMarks("t2");
        Integer aaa=1;
//        for(String c:consume){
//            Integer value=initialMarking.get(availablePlaces.getIndexOfPlace(c));
//            value--;
//            initialMarking.set(availablePlaces.getIndexOfPlace(c),value);
//        }
    }

    public void producterT(String ID){
        List <String> product=availableEdges.productMarks(ID);

        for(String p:product){
            int index=availablePlaces.getIndexOfPlace(p);
            Integer value=initialMarking.get(index);
            value++;
            initialMarking.set(availablePlaces.getIndexOfPlace(p),value);
        }

    }
    public void startsTransition(String ID)
    {
        producterT(ID);
        consumerT(ID);

        System.out.println(initialMarking);

    }




}
