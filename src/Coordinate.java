import java.util.Objects;

public class Coordinate {
    private int row;
    private int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Coordinate(String human) {
        human = human.trim().replace(" ", "").toUpperCase(); // "A1", "A 1"
        this.row = human.charAt(0) - 'A';
        this.column = Integer.parseInt(human.substring(1)) - 1;
    }

    
     public static int getrowfromhuman(String human) {
        return human.trim().replace(" ", "").toUpperCase().charAt(0) - 'A';
    }

   public static int getcolumnfromhuman(String human) {
        String digits = human.trim().replace(" ", "").substring(1);
        return Integer.parseInt(digits) - 1;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }

   @Override
    public String toString() {
        return "" + (char)('A' + row) + (column + 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinate coordinate = (Coordinate) obj;
        return Objects.equals(row, coordinate.row)
                && Objects.equals(column, coordinate.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

}
