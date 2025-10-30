import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("unused")
public class AnAutomaticShipFactory {

    AutomaticShipFactory factory;
    List<Ship> ships;

    @BeforeEach
    void setUp() {
        factory = new AutomaticShipFactory();
    }

    @Test
    void canBeCreated() {
        assertNotNull(factory);
        assertInstanceOf(AutomaticShipFactory.class, factory, "Should be instance of AutomaticShipFactory");
    }

    @Test
    void canCreateShips() {
        ships = factory.getShips();
        assertEquals(5, ships.size(), "Should create 5 ships");
        for (var ship : ships) {
            System.out.println(ship.getName() + " at " + ship.getCoords());
        }
        // visually asserted that ships do not overlap
    }

    @Test
    void createsOneOfEachShipType() {
        ships = factory.getShips();
        int carrierCount = 0;
        int battleshipCount = 0;
        int cruiserCount = 0;
        int submarineCount = 0;
        int destroyerCount = 0;

        for (var ship : ships) {
            switch (ship.getName()) {
                case "Carrier" -> carrierCount++;
                case "Battleship" -> battleshipCount++;
                case "Patrol Boat" -> cruiserCount++;
                case "Submarine" -> submarineCount++;
                case "Destroyer" -> destroyerCount++;
            }
        }

        assertEquals(1, carrierCount, "Should create one Carrier");
        assertEquals(1, battleshipCount, "Should create one Battleship");
        assertEquals(1, cruiserCount, "Should create one Cruiser");
        assertEquals(1, submarineCount, "Should create one Submarine");
        assertEquals(1, destroyerCount, "Should create one Destroyer");
    }

    /*
     * TESTS THAT USE PRIVATE METHODS
     * 
     * @Test
     * void canCreateAShipsCoordinates() throws Exception {
     * var coordinates = factory.generateCoordinatesInDirection(new Coordinate(2,
     * 3), 4, 0, 1);
     * System.out.println("Generated coordinates: " + coordinates);
     * // visually asserted
     * assertEquals(4, coordinates.size(), "Should generate 4 coordinates");
     * }
     * 
     * @Test
     * void canTestOverlappingShips() throws Exception {
     * Set<Coordinate> coords1 = factory.generateCoordinatesInDirection(new
     * Coordinate(2, 3), 4, 0, 1);
     * 
     * Set<Coordinate> coords2 = factory.generateCoordinatesInDirection(new
     * Coordinate(2, 5), 3, 1, 0);
     * Ship ship2 = new Ship(3, "Destroyer", coords2);
     * 
     * boolean intersects = factory.checkIntersection(ship2, coords1);
     * assertEquals(true, intersects, "Ships should overlap");
     * }
     */
}
