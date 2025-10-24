import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ACell {

    // A new Cell should default to the EMPTY state
    @Test
    void testGetState() {
        Cell cell = new Cell();
        assertEquals(Cell.CellState.EMPTY, cell.getState(),
            "New cells should start in the EMPTY state");
    }

    // Setting a cell's state should update it correctly
    @Test
    void testSetState() {
        Cell cell = new Cell();

        cell.setState(Cell.CellState.OCCUPIED);
        assertEquals(Cell.CellState.OCCUPIED, cell.getState(),
            "Cell state should change to OCCUPIED");

        cell.setState(Cell.CellState.HIT);
        assertEquals(Cell.CellState.HIT, cell.getState(),
            "Cell state should change to HIT");

        cell.setState(Cell.CellState.MISS);
        assertEquals(Cell.CellState.MISS, cell.getState(),
            "Cell state should change to MISS");
    }
}
