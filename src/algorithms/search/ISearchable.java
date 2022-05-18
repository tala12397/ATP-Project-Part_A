package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public interface ISearchable {
    AState getStartState();
    AState getGoalState();
    ArrayList<AState> getAllPossibleStates(AState s);
    public int get_rows_size();
    public int get_col_size();

}
