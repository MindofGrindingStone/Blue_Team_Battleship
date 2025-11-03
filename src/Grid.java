public abstract class Grid {
    protected Cell[][] cells = new Cell[10][10];

    public Grid() {
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                cells[row][col] = new Cell();
            }
        }
    }

    // printing helper methods
    private void printHeader() {
        System.out.print("     ");
        for (int c = 1; c <= 10; c++) {
            System.out.print(ConsoleColors.CYAN);
            System.out.printf("%-3d ", c);
            System.out.print(ConsoleColors.RESET);
        }
        System.out.println();
    }

    private void printSeperator() {
        System.out.print("   " + ConsoleColors.CYAN + "+" + ConsoleColors.RESET);

        for (int c = 0; c < 10; c++) {
            System.out.print(ConsoleColors.CYAN + "---+" + ConsoleColors.RESET);
        }
        System.out.println();
    }

    // returns the symbol for a given Cellstate(subclasses control this because it
    // is different between Ocean grid and Target grid)
    public abstract String symbolFor(Cell cell);

    // main print method
    public void print() {
        printHeader();
        printSeperator();

        for (int row = 0; row < 10; row++) {
            char rowLabel = (char) ('A' + row);
            System.out.printf("%2s %s", ConsoleColors.CYAN + rowLabel, " |" + ConsoleColors.RESET);


            for (int column = 0; column < 10; column++) {
                String symbol = symbolFor(cells[row][column]);
                System.out.printf(" %s %s", symbol, ConsoleColors.CYAN + "|" + ConsoleColors.RESET);

            }

            System.out.println();
            printSeperator();
        }
    }

    public boolean inBounds(Coordinate coord) {
        int row = coord.getRow();
        int column = coord.getColumn();
        return row >= 0 && row < 10 && column >= 0 && column < 10;
    }

    protected Cell getCellAt(Coordinate coord) {
        if (!inBounds(coord))
            throw new IndexOutOfBoundsException("this is out of bounds choose a different location");

        return cells[coord.getRow()][coord.getColumn()];
    }

    protected void setCellState(Coordinate coord, CellState state) {
        getCellAt(coord).setState(state);

    }

    protected CellState getCellState(Coordinate coord) {
        return getCellAt(coord).getState();
    }

}
