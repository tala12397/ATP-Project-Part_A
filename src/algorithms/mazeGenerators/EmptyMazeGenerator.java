package algorithms.mazeGenerators;

/**
 * class which generate a maze without walls.
 */
public class EmptyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns){
        return new Maze(rows,columns,0);
    }



}
