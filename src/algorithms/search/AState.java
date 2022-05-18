package algorithms.search;

public abstract class AState {
    private String state;
    protected double cost;
    private AState cameFrom;

    public AState(String s){
        this.state = s;
    }
    public abstract String to_String();
    public abstract boolean equals(Object o);
    public abstract int getRowIndex();
    public abstract int getColumnIndex();
    public void Add_came_from(AState cF){
        this.cameFrom = cF;
    }
    public AState get_came_from(){
        return this.cameFrom;
    }

}
