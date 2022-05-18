package algorithms.search;
import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm{

    public String getName(){
        return "BreadthFirstSearch";
    }
    public Solution solve(ISearchable iS){
        if(iS == null || iS.getStartState() == null)
            return null;
        this.sol = bfs(iS, iS.getStartState());
        return this.sol;
    }
    private Solution bfs(ISearchable iS, AState curr){
        if(iS==null || curr == null)
            return null;
        boolean visited[][] = new boolean[iS.get_rows_size()][iS.get_col_size()];
        LinkedList<AState> queue = new LinkedList<AState>();
        visited[curr.getRowIndex()][curr.getColumnIndex()] = true;
        queue.add(curr);
        AState n = iS.getStartState();
        while (!n.equals(iS.getGoalState()) && queue.size()!=0) {
            curr = queue.poll();
            this.num_of_nude++;
            Iterator<AState> i = iS.getAllPossibleStates(curr).listIterator();
            while (i.hasNext()) {
                 n = i.next();
                if (!visited[n.getRowIndex()][n.getColumnIndex()]) {
                    visited[n.getRowIndex()][n.getColumnIndex()] = true;
                    queue.add(n);
                    n.Add_came_from(curr);
                }
                if(n.equals(iS.getGoalState())){
                    break;
                }


            }

        }
        n.Add_came_from(curr);

        AState pointer = n;
        Solution ans = new Solution();
        while (!pointer.equals(iS.getStartState())) {
            ans.add_to_solution(pointer);
            pointer = pointer.get_came_from();
        }
        ans.add_to_solution(pointer);
        Collections.reverse(ans.getSolutionPath());

        return ans;
    }

}
