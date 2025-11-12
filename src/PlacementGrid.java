
// PlacementGrid represents the player's ocean where ships are placed
public class PlacementGrid extends Grid {


    public PlacementGrid() {
        super();
    }

    // Assign a single ship to the grid
    public void assignShip(Ship ship) {
        for (Coordinate coord : ship.getCoords()) {
            setCellState(coord, CellState.OCCUPIED);
            getCellAt(coord).setShip(ship);
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
