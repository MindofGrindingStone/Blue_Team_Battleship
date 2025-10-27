
import java.util.*;

public abstract class ShipFactory {

    private List<Ship> ships = new ArrayList<>();
    private Set<Coordinate> occupiedCoordinates = new HashSet<>();

    public List<Ship> getShips() {
    }

    private void createShips() {
    }

    protected abstract void coordinate();

    public void chooseStartingCoordinate(String name, int length) {

    }

    protected abstract void direction(char dir);

}
