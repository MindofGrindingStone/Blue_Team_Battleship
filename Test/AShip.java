import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AShip {

    //ship = name, coordinates, length
    //assign ship a name and verify getName returns the correct value
    @Test
    void testGetName() throws Exception {
        List<Coordinate> coords = Arrays.asList(new Coordinate("A1"), new Coordinate("A2"));
        Ship ship = new Ship("Destroyer", coords, 2);

        assertEquals("Destroyer", ship.getName(), "Ship name should match constructor value");
    }

    //verify getLength finds the correct value
    @Test
    void testGetLength() throws Exception {
        List<Coordinate> coords = Arrays.asList(new Coordinate("B1"), new Coordinate("B2"), new Coordinate("B3"));
        Ship ship = new Ship("Cruiser", coords, 3);

        assertEquals(3, ship.getLength(), "Ship length should match constructor value");
    }

    //verify that ship can find the coordinates
    @Test
    void testGetCoordinates() throws Exception {
        List<Coordinate> coords = Arrays.asList(new Coordinate("C1"), new Coordinate("C2"));
        Ship ship = new Ship("Submarine", coords, 2);

        assertIterableEquals(coords, ship.getCoordinates(),
            "Ship coordinates should match the list passed to constructor");
    }
}
