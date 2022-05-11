package algorithms.mazeGenerators;

import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.Maze;

public class SimpleMazeGenerator extends AMazeGenerator {
    public SimpleMazeGenerator(){

    }
    public Maze generate(int rows, int columns){
        Maze simplemaze = new Maze(rows,columns);
        if(simplemaze.start.getRowIndex()<simplemaze.end.getRowIndex()){
            int counter = simplemaze.start.getRowIndex() + 1;
            while(counter < simplemaze.end.getRowIndex()){
                simplemaze.maze[counter][simplemaze.start.getColumnIndex()] = 0;
                counter++;
            }

        }
        else{
            int counter = simplemaze.end.getRowIndex() + 1;
            while(counter < simplemaze.start.getRowIndex()){
                simplemaze.maze[counter][simplemaze.end.getColumnIndex()] = 0;
                counter++;
            }
        }
        if(simplemaze.start.getColumnIndex()<simplemaze.end.getColumnIndex()){
            int counter = simplemaze.start.getColumnIndex() + 1;
            while(counter < simplemaze.end.getColumnIndex()){
                simplemaze.maze[simplemaze.start.getRowIndex()][counter] = 0;
                counter++;
            }

        }
        else{
            int counter = simplemaze.end.getColumnIndex() + 1;
            while(counter < simplemaze.start.getColumnIndex()){
                simplemaze.maze[simplemaze.end.getRowIndex()][counter] = 0;
                counter++;
            }
        }
        return simplemaze;

    }

}
