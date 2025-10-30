import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class ManualShipFactory extends ShipFactory {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public Coordinate chooseStartingCoordinate(String name, int length) throws Exception {
        System.out.print("Enter starting coordinate for " + name + " (length " + length + "): ");
        String input = scanner.nextLine().trim();
        return new Coordinate(input); // uses Coordinate(String human) constructor
    }

    @Override
    protected Direction chooseOrientation() {
        while (true) {
            System.out.print("Enter orientation (N/E/S/W): ");
            String input = scanner.nextLine().trim().toUpperCase();
            switch (input) {
                case "N": return Direction.NORTH;
                case "E": return Direction.EAST;
                case "S": return Direction.SOUTH;
                case "W": return Direction.WEST;
                default:
                    System.out.println("Invalid orientation. Please enter N, E, S, or W.");
            }
        }
    }
}

