
import java.util.*;

public abstract class ShipFactory {

    public List<Ship> getShips() {
        return createShips();
    }

    private List<Ship> createShips() {
        List<Ship> ships= new ArrayList<>();
        Set<Coordinate> occupiedCoordinates = new HashSet<>();
        for (Map.Entry<String, Integer> entry : Constants.getSHIP_SPECS().entrySet()) {
            String name = entry.getKey();
            int length = entry.getValue();
            while (true) {
                try {
                    // Prompt user for coordinates
                    Set<Coordinate> coordinates = generateCoordinates(name, length);
                    Ship ship = new Ship(length, name, coordinates);
                    if (!checkIntersection(ship, occupiedCoordinates)) {
                        occupiedCoordinates.addAll(ship.getCoords());
                        ships.add(ship);
                        break; // Exit the loop if ship is successfully created
                    } else {
                        if (this instanceof ManualShipFactory) {
                            System.out.println("Error: Ship coordinates overlap with existing ships. Please try again.");
                        }
                    }
                } catch (Exception e) {
                    if (this instanceof ManualShipFactory) {
                        System.out.println("Error: " + e.getMessage() + ". Please try again.");
                    }
                }
            }
        }
        return ships;
    }

    protected abstract Coordinate chooseStartingCoordinate(String name, int length) throws Exception;

    protected abstract Direction chooseOrientation();
    
    private Set<Coordinate> generateCoordinates(String name, int length) {
        while (true) {
            try {
                Coordinate coord = chooseStartingCoordinate(name, length);
                Direction orientation = chooseOrientation();
                switch (orientation) {
                    case Direction.NORTH:
                        return generateCoordinatesInDirection(coord, length, 0, -1);
                    case Direction.EAST:
                        return generateCoordinatesInDirection(coord, length, 1, 0);
                    case Direction.SOUTH:
                        return generateCoordinatesInDirection(coord, length, 0, 1);
                    case Direction.WEST:
                        return generateCoordinatesInDirection(coord, length, -1, 0);
                    default:
                        if (this instanceof ManualShipFactory) {
                            System.out.println("Invalid orientation. Please enter N, E, S, or W.");
                        }
                }
            } catch (Exception e) {
                if (this instanceof ManualShipFactory) {
                    System.out.println("Invalid input. Please enter the try again.");
                }
            }
        }
    }


    private Set<Coordinate> generateCoordinatesInDirection(Coordinate coord, int length, int x_offset, int y_offset) throws Exception {
        Set<Coordinate> coordinates = new HashSet<>();
        for (int i = 0; i < length; i++) {
            coordinates.add(new Coordinate(coord.getRow() + i * x_offset, coord.getColumn() + i * y_offset));
        }
        return coordinates;
    }

    public boolean checkIntersection(Ship ship, Set<Coordinate> occupiedCoordinates) {
        Set<Coordinate> intersection = new HashSet<>(ship.getCoords());
        intersection.retainAll(occupiedCoordinates);
        if (intersection.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    


}
