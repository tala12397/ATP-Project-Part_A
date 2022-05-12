package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MyMazeGenerator extends AMazeGenerator {
    public Maze generate(int rows, int columns){
        Maze mymaze = new Maze(rows,columns);
        for(int i=0; i< mymaze.maze.length;i++){
            for (int j=0; j<mymaze.maze[0].length;j++){
                mymaze.maze[i][j] = 1;
            }
        }
        mymaze.maze[mymaze.start.getRowIndex()][mymaze.start.getColumnIndex()] = 0;

        recursion(mymaze.start.getRowIndex(),mymaze.start.getColumnIndex(), mymaze);
        mymaze.maze[mymaze.end.getRowIndex()][mymaze.end.getColumnIndex()] = 0;

        return mymaze;
    }
    public void recursion(int r, int c, Maze maze) {
        Integer[] randDirs = generateRandomDirections();
        // Examine each direction
        Stack<Position> positionStack = new Stack<>();
        positionStack.push(maze.start);
        Position now;
        while(positionStack.size()>0) {

            for (int i = 0; i < randDirs.length; i++) {

                switch (randDirs[i]) {
                    case 1: // Up
                        //　Whether 2 cells up is out or not
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
                        // Whether 2 cells to the right is out or not
                        if (c + 2 >= maze.maze[0].length-1) {
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
                        // Whether 2 cells down is out or not
                        if (r + 2 >= maze.maze.length-1)
                            continue;
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
                        // Whether 2 cells to the left is out or not
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


    /**
     * Generate an array with random directions 1-4
     * @return Array containing 4 directions in random order
     */
    public Integer[] generateRandomDirections() {
        ArrayList<Integer> randoms = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            randoms.add(i + 1);
        Collections.shuffle(randoms);

        return randoms.toArray(new Integer[4]);
    }
}
