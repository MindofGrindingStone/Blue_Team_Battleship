import java.io.Console;
import java.util.ArrayList;
import java.util.List;

// OceanGrid represents the player's ocean where ships are placed
public class OceanGrid extends Grid {

    private List<Ship> ships = new ArrayList<>(); // Keeps track of all placed ships

    public OceanGrid() {
        super();
    }

    // Assign a single ship to the grid
    public void assignShip(List<Coordinate> shipCoordinates, Ship ship) {
        for (Coordinate coord : shipCoordinates) {
            setCellState(coord, CellState.OCCUPIED);
            getCellAt(coord).setShip(ship);
        }
    }

    // Assign multiple ships and place them on the grid
    public void assignShips(List<Ship> shipsToAdd) {
        for (Ship ship : shipsToAdd) {
            assignShip(new ArrayList<>(ship.getCoords()), ship);
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
    public String symbolFor(Cell cell) {
        return switch (cell.getState()) {
            case EMPTY -> " ";
            case OCCUPIED -> ConsoleColors.GREY + String.valueOf(cell.getShip().getName().charAt(0)) + ConsoleColors.RESET; // First letter of ship name
            case HIT -> ConsoleColors.RED + "X" + ConsoleColors.RESET;
            case MISS -> ConsoleColors.WHITE + "0" + ConsoleColors.RESET;
        };
    }
}
