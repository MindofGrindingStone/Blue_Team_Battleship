public class AutomaticShipFactory extends ShipFactory {
    

    protected Coordinate chooseStartingCoordinate(String name, int length) {
        return Coordinate.randomCoordinate();
    }

    
    protected Direction chooseOrientation() {
        return Direction.randomDirection();
    }
}
