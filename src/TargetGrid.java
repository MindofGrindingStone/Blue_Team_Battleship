public class TargetGrid extends Grid {

    public TargetGrid() {
        super();
    }

    //shows your shots; only hits and misses visible
    @Override
    public String symbolFor(Cell cell) {
        return switch (cell.getState()) {
            case EMPTY -> " " ;
            case HIT -> ConsoleColors.RED + "X" + ConsoleColors.RESET;
            case MISS -> ConsoleColors.WHITE + "0" + ConsoleColors.RESET;
            case OCCUPIED -> " " ; // should not happen in TargetGrid, treat as empty 
        };
    }
    
}
