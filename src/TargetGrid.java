public class TargetGrid extends Grid {

    public TargetGrid() {
        super();
    }

    //shows your shots; only hits and misses visible
    @Override
    public char symbolFor(Cell cell) {
        return switch (cell.getState()) {
            case EMPTY -> '-';
            case HIT -> 'X';
            case MISS -> '0';
            case OCCUPIED -> '-'; // should not happen in TargetGrid, treat as empty 
        };
    }
    
}
