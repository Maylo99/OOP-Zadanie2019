package PS;

import java.util.List;

public class Transition extends PetrihoSiet{
    private List<String> transition;

    public List<String> getTransition() {
        return transition;
    }
    public Transition(List<String> transition) {
        this.transition = transition;
    }
}
