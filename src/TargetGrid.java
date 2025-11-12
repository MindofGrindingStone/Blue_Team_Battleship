public class TargetGrid extends Grid {

    public TargetGrid() {
        super();
    }

    // Shows your shots; only hits and misses visible
    @Override
    public String symbolFor(Cell cell) {
        return switch (cell.getState()) {
            case EMPTY -> " ";
            case HIT -> ConsoleColors.RED + "X" + ConsoleColors.RESET;
            case MISS -> ConsoleColors.WHITE + "0" + ConsoleColors.RESET;
            case OCCUPIED -> " "; // should not happen in TargetGrid, treat as empty 
        };
    }

    //Returns true if cell has not been shot at
    public boolean verifyShot(Coordinate coord) {
        int row = coord.getRow();
        int col = coord.getColumn();

        // Bounds check to prevent invalid coordinate access
        if (row < 0 || row >= 10 || col < 0 || col >= 10) {
            System.out.println("Invalid coordinates.");
            return false;
        }

        Cell targetCell = cells[row][col];
        CellState state = targetCell.getState();

        // Already fired here
        if (state == CellState.HIT || state == CellState.MISS) {
            System.out.println("You already fired at that location!");
            return false;
        }

        // Otherwise, valid shot
        return true;
    }
    public void recieveShotResult(Coordinate shotLocation,  CellState result){
        cells[shotLocation.getRow()][shotLocation.getColumn()].setState(result);
    }
}
