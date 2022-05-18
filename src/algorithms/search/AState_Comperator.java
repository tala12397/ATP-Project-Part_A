package algorithms.search;

import java.util.Comparator;

public class AState_Comperator implements Comparator<AState> {
    public int compare(AState a, AState b){
        if(a.cost < b.cost)
            return -1;
        if(a.cost > b.cost)
            return 1;
        return 0;
    }
}
