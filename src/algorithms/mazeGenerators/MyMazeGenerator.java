package algorithms.mazeGenerators;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int columns){
        Maze mymaze =  new Maze(rows,columns);
        for(int i=0; i< mymaze.maze.length;i++){
            for (int j=0; j<mymaze.maze[0].length;j++){
                mymaze.maze[i][j] = 1;
            }
        }
        mymaze.maze[mymaze.start.getRowIndex()][mymaze.start.getColumnIndex()] = 0;
        creation(mymaze.start.getRowIndex(),mymaze.start.getColumnIndex(), mymaze);
        mymaze.maze[mymaze.end.getRowIndex()][mymaze.end.getColumnIndex()] = 0;
        return mymaze;
    }
    public void creation(int r, int c, Maze maze) {
        Integer[] randDirs = generateRandomDirections();
        Stack<Position> positionStack = new Stack<>();
        positionStack.push(maze.start);
        Position now;
        while(positionStack.size()>0) {

            for (int i = 0; i < randDirs.length; i++) {
                switch (randDirs[i]) {
                    case 1: // Up
                        //　check if possible
                        if (r - 2 < 0) {
                            continue;
                        }

                        if (maze.maze[r - 2][c] != 0) {
                            maze.maze[r - 2][c] = 0;
                            maze.maze[r - 1][c] = 0;
                            now = new Position(r-2,c);
                            positionStack.push(now);
                            r = now.getRowIndex();
                            c = now.getColumnIndex();
                            i=0;

                        }
                        break;
                    case 2: // Right
                        // check if possible
                        if (c + 2 >= maze.maze[0].length) {
                            continue;
                        }
                        if (maze.maze[r][c + 2] != 0) {
                            maze.maze[r][c + 2] = 0;
                            maze.maze[r][c + 1] = 0;
                            now = new Position(r,c+2);
                            positionStack.push(now);
                            r = now.getRowIndex();
                            c = now.getColumnIndex();
                            i=0;

                        }
                        break;
                    case 3: // Down
                        // check if possible
                        if (r + 2 >= maze.maze.length) {
                            continue;
                        }
                        if (maze.maze[r + 2][c] != 0) {
                            maze.maze[r + 2][c] = 0;
                            maze.maze[r + 1][c] = 0;
                            now = new Position(r+2,c);
                            positionStack.push(now);
                            r = now.getRowIndex();
                            c = now.getColumnIndex();
                            i=0;
                        }
                        break;
                    case 4: // Left
                        // check if possible
                        if (c - 2 < 0)
                            continue;
                        if (maze.maze[r][c - 2] != 0) {
                            maze.maze[r][c - 2] = 0;
                            maze.maze[r][c - 1] = 0;
                            now = new Position(r,c-2);
                            positionStack.push(now);
                            r = now.getRowIndex();
                            c = now.getColumnIndex();
                            i=0;

                        }
                        break;
                }

            }

            positionStack.pop();
            if (positionStack.size() == 0)
                break;
            now = positionStack.peek();
            r = now.getRowIndex();
            c = now.getColumnIndex();
        }
    }


    //random directions
    public Integer[] generateRandomDirections() {
        ArrayList<Integer> randoms = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            randoms.add(i + 1);
        Collections.shuffle(randoms);

        return randoms.toArray(new Integer[4]);
    }
}
