package algorithms.mazeGenerators;

import algorithms.mazeGenerators.Maze;

public abstract class AMazeGenerator implements IMazeGenerator {

    abstract public Maze generate(int rows, int columns);

    public long measureAlgorithmTimeMillis(int rows, int columns){
        long time = System.currentTimeMillis();
        generate(rows, columns);
        return System.currentTimeMillis() - time ;
    }

}
