package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    public Maze generate(int rows, int columns){
        return new Maze(rows,columns,0);
    }
    public EmptyMazeGenerator(){

    }


}
