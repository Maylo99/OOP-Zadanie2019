package PS;

import java.util.List;

public class Place extends PetrihoSiet {
    private List<String> place;

    public List<String> getPlace() {
        return place;
    }
    public Place(List<String> place) {
        this.place = place;
    }
}
