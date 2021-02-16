package PS;

import java.util.List;

public class Place extends PetrihoSiet{
    private List<String> place;

    public Place(List<String> place) {
        this.place = place;
    }
    public int getIndexOfPlace(String plc)
    {
        System.out.println();
        return place.indexOf(plc);
    }


}
