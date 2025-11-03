public class Cell {

    private CellState state;
    Ship ship = null;

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

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
}