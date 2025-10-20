import java.util.List;

public class Game {
    
    List<Player> players;

    public Game(List<Player> players) {
        this.players = players;
    }

    public void play() { // method is not fully functional, only currently shows the grid of the first player
        players.get(0).displayGrids(); // temporary line to test grid printing
        System.out.println("Thanks for showing up " + players.get(0).getName() + "!");
        ConsoleHelper.getInput("Press Enter to continue...");
    }

    public void playTutorial() {
        // tutorial logic
    }
}
