
public abstract class AutomaticShipFactory extends ShipFactory {
    protected abstract Coordinate chooseStartingCoordinate(String name, int length) throws Exception;
    
    protected abstract Direction chooseOrientation();
}
