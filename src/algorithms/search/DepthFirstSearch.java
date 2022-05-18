package algorithms.search;

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class DepthFirstSearch extends ASearchingAlgorithm{

    public String getName(){
        return "DepthFirstSearch";
    }
    public Solution solve(ISearchable iS){
        if(iS == null || iS.getStartState() == null)
            return null;
        this.sol = dfs(iS, iS.getStartState());
        return this.sol;
    }
    private Solution dfs(ISearchable iS, AState curr){
        if(iS == null || curr == null)
            return null;
        boolean visited[][] = new boolean[iS.get_rows_size()][iS.get_col_size()];
        Stack<AState> stack = new Stack<>();
        stack.push(curr);
        AState n = curr;
        while(!stack.empty() && !n.equals(iS.getGoalState())){
            curr = stack.peek();
            stack.pop();
            this.num_of_nude++;
           if (!visited[curr.getRowIndex()][curr.getColumnIndex()]){
                visited[curr.getRowIndex()][curr.getColumnIndex()] = true;
            }
           Iterator<AState> i = iS.getAllPossibleStates(curr).listIterator();
           while(i.hasNext()){
               n = i.next();
               if(!visited[n.getRowIndex()][n.getColumnIndex()]){
                   stack.push(n);
                   n.Add_came_from(curr);
               }
               if(n.equals(iS.getGoalState()))
                   break;
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
