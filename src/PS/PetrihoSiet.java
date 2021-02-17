package PS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetrihoSiet {
    private List<Integer> initialMarking;
    private Map<String,Integer> currentlyMarking;
    private Place availablePlaces;
    private Transition availableTransitions;
    private Edge availableEdges;

    public void createPS(List <String> edge,List <String> place,List <String> transition,List<Integer> marking)
    {
        availableEdges=new Edge(edge);
        availablePlaces=new Place(place);
        availableTransitions=new Transition(transition);
        initialMarking=marking;
        createCurrentlyMarking(place,marking);

    }
    private Map<String,Integer> createCurrentlyMarking(List <String> place,List<Integer> marking){
        Map<String,Integer> pairMarksAndPlaces=new HashMap<>();
        for (int i=0;i<initialMarking.size();i++){
            pairMarksAndPlaces.put(place.get(i),marking.get(i));
        }
        return pairMarksAndPlaces;
    }


    public void consumerT(String ID){
        Map<String,Integer> consume=availableEdges.consumeMarks("t2");
        Integer changeOfMarks=0;
        for(Map.Entry<String,Integer> entryentryProduct :consume.entrySet()){
            for(Map.Entry<String,Integer> entryCurerent :currentlyMarking.entrySet()){
                if(entryCurerent.getKey()==entryentryProduct.getKey())
                {
                    changeOfMarks=entryCurerent.getValue()-entryentryProduct.getValue();
                    currentlyMarking.put(entryCurerent.getKey(),changeOfMarks);
                }
            }
        }
    }

    public void producterT(String ID){
        Map <String,Integer> product=availableEdges.productMarks(ID);
        Integer changeOfMarks=0;
        for(Map.Entry<String,Integer> entryentryProduct :product.entrySet()){
            for(Map.Entry<String,Integer> entryCurerent :currentlyMarking.entrySet()){
                if(entryCurerent.getKey()==entryentryProduct.getKey())
                {
                    changeOfMarks=entryCurerent.getValue()+entryentryProduct.getValue();
                    currentlyMarking.put(entryCurerent.getKey(),changeOfMarks);
                }
            }
        }
    }
    public void startsTransition(String ID)
    {
        consumerT(ID);
        producterT(ID);
        System.out.println(currentlyMarking);

    }




}
