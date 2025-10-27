
import java.util.*;

public abstract class ShipFactory {

    private List<Ship> ships;
    private Set<Coordinate> coordinates;

    public List<Ship> getShips() {
    }

    private void createShips() {
    }

    protected abstract void coordinate();

    public void chooseStartingCoordinate(String name, int length) {

    }

    protected abstract void direction(char dir);

}
