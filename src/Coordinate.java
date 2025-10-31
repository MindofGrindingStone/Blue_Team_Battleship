import java.util.Objects;
import java.util.Random;

public class Coordinate {
    
    private static Random random = new Random();

    private int row;
    private int column;

    public Coordinate(int row, int column) throws Exception {
        if (row < 0 || row > 9) {
            throw new Exception("Invalid row for coordinate.");
        } else {
            this.row = row;
        }

        if (column < 0 || column > 9) {
            throw new Exception("Invalid column for coordinate.");
        } else {
            this.column = column;
        }
    }

    public Coordinate(String human) throws Exception {
        human = human.trim().replace(" ", "").toUpperCase(); 
        this.row = getrowfromhuman(human);
        this.column = getcolumnfromhuman(human);
    }


    public static int getrowfromhuman(String human) throws Exception {
        int row = human.trim().replace(" ", "").toUpperCase().charAt(0) - 'A';
        if (row < 0 || row > 9) {
            throw new Exception("Invalid row for coordinate.");
        }
        return row;
    }

   public static int getcolumnfromhuman(String human) throws Exception {
        String digits = human.trim().replace(" ", "").substring(1);
        int column = Integer.parseInt(digits) - 1;
        if (column < 0 || column > 9) {
            throw new Exception("Invalid column for coordinate.");
        }
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
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

    public static Coordinate randomCoordinate() {
        int row = random.nextInt(10);
        int column = random.nextInt(10);
        try {
            return new Coordinate(row, column);
        } catch (Exception e) {
            // This should never happen since we are generating valid coordinates
            return null;
        }
    }

}
