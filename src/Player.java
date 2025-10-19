public class Player {
    private String name;
    private OceanGrid oceanGrid;

    public Player(String name) {
        this.name = name;
        this.oceanGrid = new OceanGrid();
    }

    public String getName() {
        return name;
    }

    public void displayOceanGrid() { // temporary method to show the customer the printing of a grid
        oceanGrid.print();
    }

}
