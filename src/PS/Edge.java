package PS;


import java.util.ArrayList;
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

    public List<String> productMarks(String ID) {
        ID = ID + "-";
        List<String> TransitionToPlace = new ArrayList<>();
        for (String e : edge) {
            if (e.contains(ID)) {
                e = e.replace(ID, "");
                TransitionToPlace.add(e);
            }
        }
        return TransitionToPlace;
    }

//    public List<String> consumeMarks(String ID) {
//        ID = "-" + ID;
//        List<String> placeToTransition = new ArrayList<>();
//        for (String e : edge) {
//            if (e.contains(ID)) {
//                e = e.replace(ID, "");
//                placeToTransition.add(e);
//            }
//        }
//        return placeToTransition;
//    }
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
