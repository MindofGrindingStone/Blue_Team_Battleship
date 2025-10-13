public abstract class Grid {
    protected Cell[][] cells = new Cell[10][10];

    public Grid() {
        for(int row=0; row<10; row++) {
            for(int col=0; col<10; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    //printing helper methods
    private void printHeader() {
        
    }

    private void printSeperator() {
        
    }

    //returns the symbol for a given Cellstate(subclasses control this because it is different between Ocean grid and Target grid)
    public abstract char symbolFor(CellState state);

    //main print method
    public void print() {

    }

    protected Cell getCellAt(Coordinate coord) {
        
    }

    protected void setCellState(Coordinate coord, CellState state) {
        
    }

    protected CellState getCellState(Coordinate coord) {
        
    }
    



}
