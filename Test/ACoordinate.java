import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ACoordinate {
    @Test
    void canBeCreatedAtA1() throws Exception {
        Coordinate coordinate = new Coordinate("A1");
        assertEquals("A1", coordinate.toString());
        assertEquals(0, coordinate.getRow());
        assertEquals(0, coordinate.getColumn());
    }

    @Test
    void canBeCreatedAtC2() throws Exception {
        Coordinate coordinate = new Coordinate("C2");
        assertEquals("C2", coordinate.toString());
        assertEquals(2, coordinate.getRow());
        assertEquals(1, coordinate.getColumn());
    }

    @Test
    void canBeCreatedWithLowerCaseLetter() throws Exception {
        Coordinate coordinate = new Coordinate("a4");
        assertEquals("A4", coordinate.toString());
        assertEquals(0, coordinate.getRow());
        assertEquals(3, coordinate.getColumn());
    }

    @Test
    void canBeCreatedAtAllCells() throws Exception {
        String[] rowLetters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        for(int row = 0; row < 10; row++){
            String firstHalf = rowLetters[row];
            for(int column = 0; column < 10; column++){
                int secondHalf = column +1;
                String coord = firstHalf + Integer.toString(secondHalf);
                Coordinate coordinate = new Coordinate(coord);
                assertEquals(coord, coordinate.toString());
                assertEquals(row, coordinate.getRow());
                assertEquals(column, coordinate.getColumn());
            }
        }
    }

    @SuppressWarnings("unused")
    @Test
    void cannotBeCreatedWithBogusRow() {
        assertThrows(Exception.class, () -> {
            Coordinate coordinate = new Coordinate("X7");
        });
    }

    @SuppressWarnings("unused")
    @Test
    void cannotBeCreatedWithBogusColumn() {
        assertThrows(Exception.class, () -> {
            Coordinate coordinate = new Coordinate("C32");
        });
    }

    @SuppressWarnings("unused")
    @Test
    void cannotBeCreatedWithBogusString() {
        assertThrows(Exception.class, () -> {
            Coordinate coordinate = new Coordinate("Tedliest Catch");
        });
    }

    @Test
    void canBeCreatedWithAlternateRowAndColumn() throws Exception {
        Coordinate c = new Coordinate(5, 5);
        assertEquals("F6", c.toString());
    }

    @Test
    void canBeEquals() throws Exception{
        Coordinate coord1 = new Coordinate(1,1);
        Coordinate coord2 = new Coordinate(1,1);
        assertEquals(coord1, coord2);
    }
    
}
