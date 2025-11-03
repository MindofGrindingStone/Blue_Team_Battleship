import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AOceanGridDisplay {

    OceanGrid oceanGrid;

    @BeforeEach
    void setUp () {
    oceanGrid = new OceanGrid();
    }


    @Test
    void prints_empty_ocean() {
        oceanGrid.print();
    }

    @Test
    void canBePrintedWithMultipleCellStates() throws Exception {
        Coordinate coord = new Coordinate(1, 1);
        oceanGrid.setCellState(coord, CellState.MISS);
        oceanGrid.print();
        // visually asserted
    }

    @Test
    void canHaveShipsPlacedOnIt() throws Exception {
        Set<Coordinate> boatCoordinates = new HashSet<>();
        boatCoordinates.add(new Coordinate(1,2));
        boatCoordinates.add(new Coordinate(2,2));
        Ship pBoat = new Ship(2, "Patrol Boat", boatCoordinates);

        Set<Coordinate> destroyerCoordinates = new HashSet<>();
        destroyerCoordinates.add(new Coordinate(3,3));
        destroyerCoordinates.add(new Coordinate(3,4));
        destroyerCoordinates.add(new Coordinate(3,5));
        Ship destroyer = new Ship(3, "Destroyer", destroyerCoordinates);

        List<Ship> ships = new ArrayList<>();
        ships.add(destroyer);
        ships.add(pBoat);

        oceanGrid.assignShips(ships);
        oceanGrid.print();
        // visually asserted
    }

    @Test
    void canHaveMultipleCellStates() throws Exception {
        Set<Coordinate> boatCoordinates = new HashSet<>();
        boatCoordinates.add(new Coordinate(1,2));
        boatCoordinates.add(new Coordinate(2,2));
        Ship pBoat = new Ship(2, "Patrol Boat", boatCoordinates);

        Set<Coordinate> destroyerCoordinates = new HashSet<>();
        destroyerCoordinates.add(new Coordinate(3,3));
        destroyerCoordinates.add(new Coordinate(3,4));
        destroyerCoordinates.add(new Coordinate(3,5));
        Ship destroyer = new Ship(3, "Destroyer", destroyerCoordinates);

        List<Ship> ships = new ArrayList<>();
        ships.add(destroyer);
        ships.add(pBoat);

        oceanGrid.assignShips(ships);

        oceanGrid.setCellState(new Coordinate(3,5), CellState.HIT);
        oceanGrid.setCellState(new Coordinate(0,0), CellState.MISS);
        oceanGrid.print();
        // visually asserted
    }
}
