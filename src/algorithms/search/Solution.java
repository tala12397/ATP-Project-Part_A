package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    private ArrayList<AState> sol;

    public ArrayList<AState> getSolutionPath(){
        return this.sol;
    }
    public void add_to_solution(AState to_add){
        this.sol.add(to_add);
    }
    public Solution(){
        this.sol = new ArrayList<>();
    }
    public Solution(LinkedList<AState> queue){
        this.sol = new ArrayList<>(queue);
    }
    public boolean contain(AState to_check){
        return this.sol.contains(to_check);
    }
    public int num_of_nodes(){
        return this.sol.size() - 1;
    }
    public void remove(AState to_remove){
        this.sol.remove(to_remove);
    }
    public void remove_first(){
        this.sol.remove(this.sol.size()-1);
    }


}
