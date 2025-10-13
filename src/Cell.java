public class Cell {

    public enum CellState {
        EMPTY, OCCUPIED, HIT, MISS
    }

    private CellState state;

    public Cell() {
        //start cell as empty
        this.state = CellState.EMPTY; 
    }
        //allow others to check state
    public CellState getState() {
        return state;
    }
        //set cell state
    public void setState(CellState newState) {
        this.state = newState;
    }
    
}