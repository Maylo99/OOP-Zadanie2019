package PS;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Edge extends PetrihoSiet {
    private List<String> edge;


    public List<String> getEdge() {
        return edge;
    }

    public Edge(List<String> edge) {
        this.edge = edge;
    }

    public Map<String,Integer> productMarks(String ID) {
        ID = ID + "-";
        Map<String,Integer> TransitionToPlaceplace = new HashMap<>();
        Integer i=0;
        for (String e : edge) {
            if (e.contains(ID)) {
                e = e.replace(ID, "");
                if (TransitionToPlaceplace.containsKey(e)){
                    i=TransitionToPlaceplace.get(e)+1;
                    TransitionToPlaceplace.put(e,i);
                }
                else
                    TransitionToPlaceplace.put(e,1);
            }
        }
        return TransitionToPlaceplace;
    }
    public Map<String,Integer> consumeMarks(String ID) {
        ID = "-" + ID;
        Map<String,Integer> placeToTransition = new HashMap<>();
        Integer i=0;

        for (String e : edge) {
            if (e.contains(ID)) {
                e = e.replace(ID, "");
                if (placeToTransition.containsKey(e)){
                    i=placeToTransition.get(e)+1;
                    placeToTransition.put(e,i);
                }
                else
                    placeToTransition.put(e,1);
            }
        }
        return placeToTransition;
    }


}
