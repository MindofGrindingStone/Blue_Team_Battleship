public class Player {
    private String name;
    public OceanGrid oceanGrid;
    private TargetGrid targetGrid;
    public ShipFactory shipFactory;

    public Player(String name, ShipFactory shipFactory) {
        this.name = name;
        this.oceanGrid = new OceanGrid();
        this.targetGrid = new TargetGrid();
        this.shipFactory = shipFactory;
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

}
