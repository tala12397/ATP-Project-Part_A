package algorithms.mazeGenerators;

import java.util.Random;
public class Maze {
    int [][] maze;
    Position start;
    Position end;

    public Maze(int row, int col){
        Random rand = new Random();
        this.maze = new int[row][col];
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++)
                this.maze[i][j] = rand.nextInt(2);
        }

        int startx = rand.nextInt(row);
        while(startx%2==0){
            startx = rand.nextInt(row);
        }
        int starty;
        if(startx==(row-1)){
            starty = rand.nextInt(col);
            while(starty%2==1)
                starty = rand.nextInt(col);
        }
        else{
            starty = rand.nextInt(2);
            if (starty == 1){
                starty = col-1;
            }
        }
        this.start = new Position(startx,starty);
        int endx = rand.nextInt(row);
        while(endx%2 ==0){
            endx = rand.nextInt(row);
        }
        int endy = 0;
        if(endx==(row-1) || endx == 0){
            endy = rand.nextInt(col);
        }
        while(endx==startx && endy == starty){
            endx = rand.nextInt(row);
        }
        this.end = new Position(endx,endy);
        this.maze[startx][starty] = 0;
        this.maze[endx][endy] = 0;

    }
    public Maze(int row, int col, int num){
        this.maze = new int[row][col];
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++)
                this.maze[i][j] = num;
        }
        this.start = new Position(0,0);
        this.end = new Position(row-1, col-1);
    }
    public Position getStartPosition(){
        return this.start;
    }
    public Position getGoalPosition(){
        return this.end;
    }
    public void print() {
        System.out.print("{");
        for (int i = 0; i < this.maze.length; i++) { //this equals to the row in our matrix.
            if(i==0)
                System.out.print("{");
            else
                System.out.print(",{");
            for (int j = 0; j < this.maze[i].length-1; j++) { //this equals to the column in each row.
                if(this.start.getRowIndex() == i && this.start.getColumnIndex() == j){
                    System.out.print("S,");
                }
                else if(this.end.getRowIndex() == i && this.end.getColumnIndex() == j){
                    System.out.print("E,");
                }
                else {
                    System.out.print(this.maze[i][j] + ",");
                }
            }
            if(this.start.getRowIndex() == i && this.start.getColumnIndex() == this.maze[i].length-1){
                System.out.print("S");
            }
            else if(this.end.getRowIndex() == i && this.end.getColumnIndex() == this.maze[i].length-1){
                System.out.print("E");
            }
            else {
                System.out.print(this.maze[i][this.maze[i].length-1]);
            }
            if(i==this.maze.length-1){
                System.out.print("}}");
                System.out.println();
            }
            else {
                System.out.print("}");
                System.out.println(); //change line on console as row comes to end in the matrix.
            }

        }
        //System.out.print("}");
        /*System.out.print("{");
        for (int i = 0; i < this.maze.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < this.maze[i].length; j++) { //this equals to the column in each row.
                if(this.start.getRowIndex() == i && this.start.getColumnIndex() == j){
                    System.out.print("S,");
                }
                if(this.end.getRowIndex() == i && this.end.getColumnIndex() == j){
                    System.out.print("E,");
                }

                System.out.print(this.maze[i][j] + ",");
            }
        }
        System.out.println();
        System.out.print("}");*/

    }


}


