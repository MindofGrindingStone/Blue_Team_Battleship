import java.util.ArrayList;
import java.util.List;

// OceanGrid represents the player's ocean where ships are placed
public class OceanGrid extends Grid {

    private List<Ship> ships = new ArrayList<>(); // Keeps track of all placed ships

    public OceanGrid() {
        super();
    }

    // Assign a single ship to the grid
    public void assignShip(List<Coordinate> shipCoordinates) {
        for (Coordinate coord : shipCoordinates) {
            setCellState(coord, CellState.OCCUPIED);
        }
    }

    // Assign multiple ships and place them on the grid
    public void assignShips(List<Ship> shipsToAdd) {
        for (Ship ship : shipsToAdd) {
            assignShip(new ArrayList<>(ship.getCoords()));
            ships.add(ship);
        }
    }

    // Process a shot at a coordinate and return whether it was a hit or miss
    public CellState receiveShot(Coordinate coord) {
        Cell cell = getCellAt(coord);

        if (cell.getState() == CellState.OCCUPIED) {
            cell.setState(CellState.HIT);
            return CellState.HIT;
        } else {
            cell.setState(CellState.MISS);
            return CellState.MISS;
        }
    }

    // Returns the symbol to display for a cell (used when printing the grid)
    @Override
    public char symbolFor(Cell cell) {
        return switch (cell.getState()) {
            case EMPTY -> '-';
            case OCCUPIED -> 'O';
            case HIT -> 'X';
            case MISS -> '0';
        };
    }
}
