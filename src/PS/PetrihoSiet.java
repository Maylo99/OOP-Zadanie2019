package PS;
import PS.CustomExceptions.InvalidEdgeException;
import PS.CustomExceptions.LackOfMarksException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PetrihoSiet {
    private List<Integer> initialMarking;
    private Map<String,Integer> currentlyMarking;
    private Place availablePlaces;
    private Transition availableTransitions;
    private Edge availableEdges;

    public void createPS(List <String> edge, List <String> place, List <String> transition, List<Integer> marking) throws InvalidEdgeException {
        availablePlaces=new Place(place);
        availableTransitions=new Transition(transition);
        availableEdges=new Edge(edge);
        try{
            availableEdges.controlInOut(edge,availablePlaces,availableTransitions);
        }catch (InvalidEdgeException e){
            System.err.println(e);
        }
        initialMarking=marking;
        currentlyMarking=createCurrentlyMarking(place,marking);

    }
    private Map<String,Integer> createCurrentlyMarking(List <String> place,List<Integer> marking){
        Map<String,Integer> pairMarksAndPlaces=new HashMap<>();
        for (int i=0;i<initialMarking.size();i++){
            pairMarksAndPlaces.put(place.get(i),marking.get(i));
        }
        return pairMarksAndPlaces;
    }

    public void consumerT(String ID) throws LackOfMarksException {
        Map<String,Integer> consume=availableEdges.consumeMarks(ID);
        Integer changeOfMarks=0;
        for(Map.Entry<String,Integer> entryentryProduct :consume.entrySet()){
            for(Map.Entry<String,Integer> entryCurerent :currentlyMarking.entrySet()){
                if(entryCurerent.getKey().equals(entryentryProduct.getKey()))
                {
                    changeOfMarks=entryCurerent.getValue()-entryentryProduct.getValue();
                    if(changeOfMarks<0){
                        throw new LackOfMarksException("Transition "+ID+" consume more marks than is available");
                    }
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
                if(entryCurerent.getKey().equals(entryentryProduct.getKey()))
                {
                    changeOfMarks=entryCurerent.getValue()+entryentryProduct.getValue();
                    currentlyMarking.put(entryCurerent.getKey(),changeOfMarks);
                }
            }
        }
    }

    public void startsTransition(String ID)
    {
        try{
            consumerT(ID);
        }
        catch(LackOfMarksException e){
            System.err.println(e);
            System.out.println("Try run another transition:");
        }
        producterT(ID);
        System.out.println("Current marks:"+currentlyMarking);
    }
}