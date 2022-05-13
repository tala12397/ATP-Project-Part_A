package algorithms.mazeGenerators;

public class SimpleMazeGenerator extends AMazeGenerator {

    public Maze generate(int rows, int columns){
        Maze simplemaze = new Maze(rows,columns);
        if(simplemaze.start.getRowIndex()<simplemaze.end.getRowIndex()){
            int counter = simplemaze.start.getRowIndex() + 1;
            while(counter <= simplemaze.end.getRowIndex()){
                simplemaze.maze[counter][simplemaze.start.getColumnIndex()] = 0;
                counter++;
            }
            if(simplemaze.start.getColumnIndex()<simplemaze.end.getColumnIndex()){
                int counte = simplemaze.start.getColumnIndex() + 1;
                while(counte <= simplemaze.end.getColumnIndex()){
                    simplemaze.maze[simplemaze.start.getRowIndex()][counte] = 0;
                    counte++;
                }

            }
            else{
                int counte = simplemaze.end.getColumnIndex() + 1;
                while(counte <= simplemaze.start.getColumnIndex()){
                    simplemaze.maze[simplemaze.end.getRowIndex()][counte] = 0;
                    counte++;
                }
            }

        }
        else{
            int counter = simplemaze.end.getRowIndex() + 1;
            while(counter <= simplemaze.start.getRowIndex()){
                simplemaze.maze[counter][simplemaze.end.getColumnIndex()] = 0;
                counter++;
            }
            if(simplemaze.start.getColumnIndex()<simplemaze.end.getColumnIndex()){
                int counte = simplemaze.start.getColumnIndex() + 1;
                while(counte <= simplemaze.end.getColumnIndex()){
                    simplemaze.maze[simplemaze.end.getRowIndex()][counte] = 0;
                    counte++;
                }

            }
            else{
                int counte = simplemaze.end.getColumnIndex() + 1;
                while(counte <= simplemaze.start.getColumnIndex()){
                    simplemaze.maze[simplemaze.start.getRowIndex()][counte] = 0;
                    counte++;
                }
            }
        }

        return simplemaze;

    }

}
