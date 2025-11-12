import java.util.ArrayList;
import java.util.List;

// OceanGrid represents the player's ocean where ships are placed
public class OceanGrid extends Grid {

    private List<Ship> ships = new ArrayList<>(); // Keeps track of all placed ships

    public OceanGrid() {
        super();
    }

    // Assign a single ship to the grid
    private void assignShip(Ship ship) {
        for (Coordinate coord : ship.getCoords()) {
            setCellState(coord, CellState.OCCUPIED);
            getCellAt(coord).setShip(ship);
        }
    }

    // Assign multiple ships and place them on the grid
    public void assignShips(List<Ship> shipsToAdd) {
        for (Ship ship : shipsToAdd) {
            assignShip(ship);
            ships.add(ship);
        }
    }

    public ShotResult receiveShot(Coordinate shot) { // NOTE: this method assumes that no duplicate shots are getting through from the other side
        Cell cell = getCellAt(shot);
        if (getCellState(shot) == CellState.OCCUPIED) {
            // get ship and make and set new cell state as well as register hit on ship
            Ship ship = cell.getShip();
            cell.setState(CellState.HIT);
            ship.registerHitAt(shot);

            // create shot result and return
            if (ship.isSunk()) {
                ShotResult shotResult = ShotResult.SUNK;
                shotResult.setShipName(ship.getName());
                shotResult.setCoordinate(shot);
                return shotResult;
            } else {
                ShotResult shotResult = ShotResult.HIT;
                shotResult.setShipName(ship.getName());
                shotResult.setCoordinate(shot);
                return shotResult;
            }
        } else {
            // if the shot is a miss, much less to worry about
            cell.setState(CellState.MISS);
            ShotResult shotResult = ShotResult.MISS;
            shotResult.setCoordinate(shot);
            return shotResult;
        }
    }

    // Returns the symbol to display for a cell (used when printing the grid)
    @Override
    public String symbolFor(Cell cell) {
        return switch (cell.getState()) {
            case EMPTY -> " ";
            case OCCUPIED ->
                ConsoleColors.GREY + String.valueOf(cell.getShip().getName().charAt(0)) + ConsoleColors.RESET; // First letter of ship name
            case HIT -> ConsoleColors.RED + "X" + ConsoleColors.RESET;
            case MISS -> ConsoleColors.WHITE + "0" + ConsoleColors.RESET;
        };
    }

    // Returns true if all ships are sunk
    public Boolean areAllShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }
}
