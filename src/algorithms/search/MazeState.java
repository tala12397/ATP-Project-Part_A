package algorithms.search;

import java.util.Objects;

public class MazeState extends AState{
    private int row;
    private int col;

    public MazeState(int r, int c, String s){
        super(s);
        this.row = r;
        this.col = c;
    }
    public MazeState(int r, int c, int cost){
        super("");
        this.row = r;
        this.col = c;
        this.cost = cost;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MazeState mazeState = (MazeState) o;
        return row == mazeState.row && col == mazeState.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
    public int getRowIndex(){
        return this.row;
    }
    public int getColumnIndex(){
        return this.col;
    }
    @Override
    public String to_String(){
        return "{" + this.row + "," + this.col + "}";
    }
}
