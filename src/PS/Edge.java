package PS;

import PS.CustomExceptions.InvalidEdgeException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Edge extends PetrihoSiet {
    private List<String> edge;

    public Edge(List<String> edge) {
        this.edge = edge;
    }

    public Map<String, Integer> productMarks(String ID) {
        ID = ID + "-";
        Map<String, Integer> TransitionToPlaceplace = new HashMap<>();
        Integer i = 0;
        for (String e : edge) {
            if (e.contains(ID)) {
                e = e.replace(ID, "");
                if (TransitionToPlaceplace.containsKey(e)) {
                    i = TransitionToPlaceplace.get(e) + 1;
                    TransitionToPlaceplace.put(e, i);
                } else
                    TransitionToPlaceplace.put(e, 1);
            }
        }
        return TransitionToPlaceplace;
    }

    public Map<String, Integer> consumeMarks(String ID) {
        ID = "-" + ID;
        Map<String, Integer> placeToTransition = new HashMap<>();
        Integer i = 0;

        for (String e : edge) {
            if (e.contains(ID)) {
                e = e.replace(ID, "");
                if (placeToTransition.containsKey(e)) {
                    i = placeToTransition.get(e) + 1;
                    placeToTransition.put(e, i);
                } else
                    placeToTransition.put(e, 1);
            }
        }
        return placeToTransition;
    }

    public void controlInOut(List<String> edge, Place availablePlaces, Transition availableTransitions) throws InvalidEdgeException {
        for (String e : edge) {
            String[] parts = e.split("-");
            if (parts.length < 2)
                throw new InvalidEdgeException("Invalid edge,can´t be Place-Place,Transition-Transition,and must have IN and also OUT destination!!");
            if (availablePlaces.getPlace().contains(parts[0]) && availableTransitions.getTransition().contains(parts[1]))
                continue;
            if (availablePlaces.getPlace().contains(parts[1]) && availableTransitions.getTransition().contains(parts[0]))
                continue;
            else
                throw new InvalidEdgeException("Invalid edge,can´t be Place-Place,Transition-Transition,and must have IN and also OUT destination!!");
        }
    }
}
