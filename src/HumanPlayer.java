import java.util.List;

public class HumanPlayer implements Player {
    private String name;
    public OceanGrid oceanGrid;
    private TargetGrid targetGrid;
    public ShipFactory shipFactory;

    public HumanPlayer(String name, ShipFactory shipFactory) {
        this.name = name;
        this.oceanGrid = new OceanGrid();
        this.targetGrid = new TargetGrid();
        this.shipFactory = shipFactory;
    }

    public ShotResult receiveShot(Coordinate coordinate) {
        return oceanGrid.receiveShot(coordinate);
    }

    public String getName() {
        return name;
    }

    public void displayGrids() { // temporary method to show the customer the printing of a grid
        System.out.print("Target Grid");
        System.out.println();
        targetGrid.print();
        System.out.println();
        System.out.println();
        System.out.print("Ocean Grid");
        System.out.println();
        oceanGrid.print();
    }

    public void reset() {
        this.oceanGrid = new OceanGrid();
        this.targetGrid = new TargetGrid();
    }

    public Coordinate takeShot() {
        Coordinate shot;
        while (true) {
            try {
                shot = new Coordinate(ConsoleHelper.getInput("Input Coordinate for shot:"));
                if (targetGrid.verifyShot(shot)){
                    break;
                } else {
                    System.out.println("You have already shot at this coordinate. Please choose another.");
                }
            } catch (Exception e) {
                System.out.println("invalid shot");
            }
        }
        return shot;
    }

    public void receiveShotResult(ShotResult result) {
        targetGrid.receiveShotResult(result);
    }

    public void placeShips() {
        List<Ship> ships = shipFactory.getShips();
        oceanGrid.assignShips(ships);
    }

    public boolean shipsAreSunk() {
        return oceanGrid.areAllShipsSunk();
    }

}
