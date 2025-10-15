import java.util.List;

public class OceanGrid extends Grid {

    public OceanGrid(int rows, int column) {
        super();
    }

    public void assignShip(List<Coordinate> shipCoordinates) {
        }

    //Take the coordinates for the shot, check to see the cell state attached to the shot and return hit or miss based on the state?
    public CellState receiveShot(Coordinate coord) {
    Cell cell = cells[coord.getRow()][coord.getColumn()];

    if (cell.getState() == CellState.OCCUPIED) {
        cell.setState(CellState.HIT);
        return CellState.HIT;
    } else {
        cell.setState(CellState.MISS);
        return CellState.MISS;
    }
}

    //Override for abstract method in grid: public abstract char symbolFor(CellState state);
    @Override
    public char symbolFor(CellState state) {
         throw new UnsupportedOperationException("Unimplemented method 'symbolFor'");
    }
}
    
