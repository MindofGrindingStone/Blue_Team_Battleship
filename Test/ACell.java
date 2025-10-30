import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ACell {

    // A new Cell should default to the EMPTY state
    @Test
    void testGetState() {
        Cell cell = new Cell();
        assertEquals(CellState.EMPTY, cell.getState(),
            "New cells should start in the EMPTY state");
    }

    // Setting a cell's state should update it correctly
    @Test
    void testSetState() {
        Cell cell = new Cell();

        cell.setState(CellState.OCCUPIED);
        assertEquals(CellState.OCCUPIED, cell.getState(),
            "Cell state should change to OCCUPIED");

        cell.setState(CellState.HIT);
        assertEquals(CellState.HIT, cell.getState(),
            "Cell state should change to HIT");

        cell.setState(CellState.MISS);
        assertEquals(CellState.MISS, cell.getState(),
            "Cell state should change to MISS");
    }
}
