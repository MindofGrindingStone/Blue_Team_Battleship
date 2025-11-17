public class Game {
    
    HumanPlayer player1;
    Player player2;
    ShotResult currentResult;

    public Game(HumanPlayer player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play() { // method is not fully functional, only currently shows the grid of the first player then has them place ships
        player1.reset();
        player2.reset();
        if (player2 instanceof HumanPlayer) {
                HumanPlayer player2 = (HumanPlayer) this.player2;
                System.out.println("Starting a new game between " + player1.getName() + " and " + player2.getName() + "!");
                if (player1.getShipFactory() instanceof ManualShipFactory) {
                System.out.println(player1.getName() + ", place your ships on your Ocean Grid:");
                } else {
                    System.out.println(player1.getName() + ", you have chosen the Automatic Ship Factory. Your ships will be placed automatically.");
                }
                player1.placeShips();
                ConsoleHelper.getInput("Press Enter to clear the console and pass to " + player2.getName() + "...");
                ConsoleHelper.clearConsole();
                if (player2.getShipFactory() instanceof ManualShipFactory) {
                System.out.println(player2.getName() + ", place your ships on your Ocean Grid:");
                } else {
                    System.out.println(player2.getName() + ", you have chosen the Automatic Ship Factory. Your ships will be placed automatically.");
                }
                player2.placeShips();
                ConsoleHelper.getInput("Press Enter to clear the console and start the match...");
                ConsoleHelper.clearConsole();
            while (true) {
                ConsoleHelper.getInput(player1.getName() + "'s turn, press enter to start:");
                player1.displayGrids();
                if (currentResult != null) {
                    RecapResults(currentResult);
                }
                currentResult = player2.receiveShot(player1.takeShot());
                DisplayResults(currentResult);
                player1.receiveShotResult(currentResult);
                if (player2.shipsAreSunk()) {
                    System.out.println(player1.getName() + " wins! All enemy ships have been sunk.");
                    break;
                }
                ConsoleHelper.getInput("Press Enter to clear the console and pass to " + player2.getName() + "...");
                ConsoleHelper.clearConsole();
                ConsoleHelper.getInput(player2.getName() + "'s turn, press enter to start:");
                RecapResults(currentResult);
                player2.displayGrids();
                currentResult = player1.receiveShot(player2.takeShot());
                DisplayResults(currentResult);
                player2.receiveShotResult(currentResult);
                if (player1.shipsAreSunk()) {
                    System.out.println(player2.getName() + " wins! All enemy ships have been sunk.");
                    break;
                }
                ConsoleHelper.getInput("Press Enter to clear the console and pass to " + player1.getName() + "...");
                ConsoleHelper.clearConsole();
            }
        } else {
            System.out.println("Starting a new game between " + player1.getName() + " and " + player2.getName() + "!");
            if (player1.getShipFactory() instanceof ManualShipFactory) {
                System.out.println(player1.getName() + ", place your ships on your Ocean Grid:");
                } else {
                    System.out.println(player1.getName() + ", you have chosen the Automatic Ship Factory. Your ships will be placed automatically.");
                }
            player1.placeShips();
            player2.placeShips();
            ConsoleHelper.getInput("Press Enter to start the match...");
            while (true) {
                player1.displayGrids();
                if (currentResult != null) {
                    RecapResults(currentResult);
                }
                currentResult = player2.receiveShot(player1.takeShot());
                DisplayResults(currentResult);
                ConsoleHelper.getInput("Press Enter to continue...");
                player1.receiveShotResult(currentResult);
                if (player2.shipsAreSunk()) {
                    System.out.println(player1.getName() + " wins! All enemy ships have been sunk.");
                    break;
                }
                currentResult = player1.receiveShot(player2.takeShot());
                player2.receiveShotResult(currentResult);
                if (player1.shipsAreSunk()) {
                    System.out.println(player2.getName() + " wins! All enemy ships have been sunk.");
                    break;
                }
            }
        }
    }

    public void playTutorial() {
    player1.reset();
    player2.reset();

    ConsoleHelper.clearConsole();

    System.out.println(ConsoleColors.GREEN + "Welcome to Battleship, " + player1.getName() + "!" + ConsoleColors.RESET);

    System.out.println("This quick walkthrough will show you the basics before a real match.");

    ConsoleHelper.getInput("\nPress Enter to begin...");

    System.out.println("\nDuring a real match, you will place all five ships, then take turns with your opponent. On your turn you fire at one coordinate on the other players ocean grid, and we will say MISS, HIT, or SUNK and mark it on your Target Grid. Then the opponent fires back at your Ocean Grid and we tell you if any of your ships were hit. So keep trading shots until every ship on one side is sunk. If two players are playing at once; the console will clear after each turn has been taken, The last fleet standing wins. Just follow each prompt and press Enter when you are ready, and the app will guide you through every step.");

    ConsoleHelper.getInput("\nPress Enter to wrap up the tutorial...");


    System.out.println(ConsoleColors.YELLOW + "\n1) Placing your fleet" + ConsoleColors.RESET);

    System.out.println("Ships sit on your Ocean Grid. Rows are A through J, columns 1 through 10.");

    OceanGrid demoOcean = new OceanGrid();
    AutomaticShipFactory demoFactory = new AutomaticShipFactory();
    demoOcean.assignShips(demoFactory.getShips());
    
    System.out.println("\nExample Ocean Grid using the automatic shipfactory:");
    demoOcean.print();
    System.out.println(ConsoleColors.YELLOW + "\n1) Placing your fleet if you picked manual shipfactory" + ConsoleColors.RESET);
    System.out.println("You start with five ships of different lengths. The labels A through J mark rows, the numbers 1 through 10 mark columns.");
    System.out.println("When we prompt for a starting coordinate, type the row letter followed by the column number (example: B7 or J10).");
    System.out.println("After that we ask for a direction: N = up, E = right, S = down, W = left. the ships1 have different lengths, and once a direction is choosen, the program will place a ship and run through each space until it reaches the end of that ship (example: Carrier has a length of 5 spaces, so it will take up five spaces of any direction you pick");
    System.out.println("If a placement would run off the board or collide with another ship, its gonna run an error and explain the parameters again");
    ConsoleHelper.getInput("\nPress Enter to learn about taking shots...");

    System.out.println(ConsoleColors.YELLOW + "\n2) Tracking shots on the Target Grid" + ConsoleColors.RESET);
    TargetGrid demoTarget = new TargetGrid();
    try {
        ShotResult miss = ShotResult.MISS;
        miss.setCoordinate(new Coordinate(2, 3));
        demoTarget.receiveShotResult(miss);

        ShotResult hit = ShotResult.HIT;
        hit.setCoordinate(new Coordinate(5, 6));
        demoTarget.receiveShotResult(hit);

        ShotResult sunk = ShotResult.SUNK;
        sunk.setCoordinate(new Coordinate(5, 7));
        demoTarget.receiveShotResult(sunk);
    } catch (Exception ignored) { }
    System.out.println("Hits appear as " + ConsoleColors.RED + "X" + ConsoleColors.RESET +
            " and misses as " + ConsoleColors.WHITE + "0" + ConsoleColors.RESET + " on your Target Grid:");
    demoTarget.print();
    ConsoleHelper.getInput("\nPress Enter to finish the tutorial...");

    System.out.println(ConsoleColors.GREEN + "\nYou're ready to play!" + ConsoleColors.RESET);
    System.out.println("1. Place every ship on your Ocean Grid.\n2. Take turns firing at coordinates.\n3. Sink every enemy ship before yours are sunk.");
    ConsoleHelper.getInput("\nPress Enter to return to the main menu...");
}


    public void DisplayResults(ShotResult result) {
        switch (result) {
            case HIT -> System.out.println(result.getCoordinate() + "'s a hit on your opponent's " + result.getShipName() + "!");
            case MISS -> System.out.println("It's a miss.");
            case SUNK -> System.out.println("You sunk your opponent's " + result.getShipName() + "!");
        }
    }

    public void RecapResults(ShotResult result) {
        switch (result) {
            case HIT -> System.out.println("Your " + result.getShipName() + " was hit at " + result.getCoordinate() + "!");
            case MISS -> System.out.println("The shot at " + result.getCoordinate() + " missed your fleet.");
            case SUNK -> System.out.println("Your " + result.getShipName() + " was sunk!");
        }
    }   
}
