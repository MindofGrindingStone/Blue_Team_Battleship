
import java.util.*;

import apple.laf.JRSUIConstants.Direction;

public abstract class ShipFactory {

    private List<Ship> ships = new ArrayList<>();
    private Set<Coordinate> occupiedCoordinates = new HashSet<>();

    public List<Ship> getShips() {
        return ships;
    }

    private void createShips() {
    }

    public abstract Coordinate chooseStartingCoordinate(String name, int length);

    protected abstract Direction chooseOrientation();
    
    private Set<Coordinate> generateCoordinates(String name, int length){
    }
    private Set<Coordinate> generateCoordinatesInDirection(Coordinate coord, int length, int x_offset, int y_offset){
    }
    


}
