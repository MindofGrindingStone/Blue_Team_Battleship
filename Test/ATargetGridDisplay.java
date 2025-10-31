import org.junit.jupiter.api.Test;

public class ATargetGridDisplay {
    static class T extends TargetGrid {
        void set(int r, int c, CellState s) throws Exception { setCellState(new Coordinate(r, c), s); }
    }

    @Test
    void prints_target() throws Exception {
        T g = new T();
        g.set(2, 5, CellState.HIT); // C6 
        g.set(9, 9, CellState.MISS); // J10 
        g.print();                 
    }
}
