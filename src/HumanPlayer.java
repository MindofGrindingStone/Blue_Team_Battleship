import java.util.List;

public class HumanPlayer implements Player {
    private String name;
    private OceanGrid oceanGrid;
    private TargetGrid targetGrid;
    public PlayerStats playerStats;
    private ShipFactory shipFactory;

    public ShipFactory getShipFactory() {
        return shipFactory;
    
    }

    public HumanPlayer(String name, ShipFactory shipFactory) {
        this.name = name;
        this.oceanGrid = new OceanGrid();
        this.targetGrid = new TargetGrid();
        this.shipFactory = shipFactory;
        this.playerStats = new PlayerStats();
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
                    playerStats.addShotFired();
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
        if (result == ShotResult.MISS){
            playerStats.addMiss();
        } else if (result == ShotResult.HIT){
            playerStats.addHit();
        }
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
