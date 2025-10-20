public class Player {
    private String name;
    private OceanGrid oceanGrid;
    private TargetGrid targetGrid;

    public Player(String name) {
        this.name = name;
        this.oceanGrid = new OceanGrid();
        this.targetGrid = new TargetGrid();
    }

    public String getName() {
        return name;
    }

    public void displayGrids() { // temporary method to show the customer the printing of a grid
        targetGrid.print();
        System.out.println();
        System.out.println();
        oceanGrid.print();
    }

}
