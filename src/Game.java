import java.util.List;

public class Game {
    
    Player player1;
    Player player2;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() { // method is not fully functional, only currently shows the grid of the first player then has them place ships
        player1.reset();
        player2.reset();
        player1.displayGrids(); // temporary line to test grid printing
        System.out.println("Thanks for showing up " + players.get(0).getName() + "!");
        for(Player player : players){
            List<Ship> ships = player.shipFactory.getShips();
            player.oceanGrid.assignShips(ships);
        }
        players.get(0).displayGrids();
        ConsoleHelper.getInput("Press Enter to continue...");
    }

    public void playTutorial() {
        System.out.println("Hey " + players.get(0).getName() + "! This is the tutorial.");
        ConsoleHelper.getInput("Press Enter to continue...");
    }
}
