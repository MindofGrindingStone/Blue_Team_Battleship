
import java.util.List;

public class Menu {

    private List<Player> players = new java.util.ArrayList<>();
    private Game game;

    private void greetUser() {
        System.out.println("\r\n"
                + //
                "\r\n"
                + //
                " __     __     ______     __         ______     ______     __    __     ______        ______   ______   \r\n"
                + //
                "/\\ \\  _ \\ \\   /\\  ___\\   /\\ \\       /\\  ___\\   /\\  __ \\   /\\ \"-./  \\   /\\  ___\\      /\\__  _\\ /\\  __ \\  \r\n"
                + //
                "\\ \\ \\/ \".\\ \\  \\ \\  __\\   \\ \\ \\____  \\ \\ \\____  \\ \\ \\/\\ \\  \\ \\ \\-./\\ \\  \\ \\  __\\      \\/_/\\ \\/ \\ \\ \\/\\ \\ \r\n"
                + //
                " \\ \\__/\".~\\_\\  \\ \\_____\\  \\ \\_____\\  \\ \\_____\\  \\ \\_____\\  \\ \\_\\ \\ \\_\\  \\ \\_____\\       \\ \\_\\  \\ \\_____\\\r\n"
                + //
                "  \\/_/   \\/_/   \\/_____/   \\/_____/   \\/_____/   \\/_____/   \\/_/  \\/_/   \\/_____/        \\/_/   \\/_____/\r\n"
                + //
                "                                                                                                        \r\n"
                + //
                " ______     ______     ______   ______   __         ______     ______     __  __     __     ______      \r\n"
                + //
                "/\\  == \\   /\\  __ \\   /\\__  _\\ /\\__  _\\ /\\ \\       /\\  ___\\   /\\  ___\\   /\\ \\_\\ \\   /\\ \\   /\\  == \\     \r\n"
                + //
                "\\ \\  __<   \\ \\  __ \\  \\/_/\\ \\/ \\/_/\\ \\/ \\ \\ \\____  \\ \\  __\\   \\ \\___  \\  \\ \\  __ \\  \\ \\ \\  \\ \\  _-/     \r\n"
                + //
                " \\ \\_____\\  \\ \\_\\ \\_\\    \\ \\_\\    \\ \\_\\  \\ \\_____\\  \\ \\_____\\  \\/\\_____\\  \\ \\_\\ \\_\\  \\ \\_\\  \\ \\_\\       \r\n"
                + //
                "  \\/_____/   \\/_/\\/_/     \\/_/     \\/_/   \\/_____/   \\/_____/   \\/_____/   \\/_/\\/_/   \\/_/   \\/_/       \r\n"
                + //
                "\r\n"
                + //
                "");
    }

    public void presentStartMenu() {
        while (true) {
            if (players == null || players.isEmpty()) {
                greetUser();
                Integer choice = Character.getNumericValue(
                        ConsoleHelper.getInput("1. Start New Game\n2. Tutorial\n3. Exit\nEnter Here: ").charAt(0));
                while (true) {
                    if (choice < 1 || choice > 3) {
                        System.out.println("Invalid choice, please try again.");
                    } else {
                        chooseStartOption(choice);
                        break;
                    }
                }
            } else {
                System.out.println("Thanks for playing Battleship! Please choose from the following options:");
                Integer choice = Character.getNumericValue(
                        ConsoleHelper.getInput("1. Replay\n2. Start New Game\n3. Tutorial\n4. Exit\nEnter Here: ")
                                .charAt(0));
                while (true) {
                    if (choice < 1 || choice > 4) {
                        System.out.println("Invalid choice, please try again.");
                    } else {
                        chooseStartOption(choice - 1);
                        break;
                    }
                }
            }
        }
    }

    private void chooseStartOption(int choice) {
        switch (choice) {
            case 0:
                game = new Game(players.get(0), players.get(1));
                game.play();
                break;
            case 1:
                players.clear();
                chooseNumberOfPlayers();
                game = new Game(players.get(0), players.get(1));
                game.play();

                break;
            case 2:
                players.clear();
                chooseNumberOfPlayers(); // needs to be revisited tutorial as a subclass of game
                game = new Game(players.get(0), players.get(1));
                game.playTutorial();
                break;
            case 3:
                System.out.println("Exiting the game. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
        }
    }

    public void chooseNumberOfPlayers() {
        /*
         * this method needs to choose the number of players then create them I think
         * also I'm not sure what to do for the tutorial option up above, I am currently
         * calling this
         * right before creating a new game to play the tutorial, maybe we need another
         * method to call
         * that would create a tutorial player? Let me know what you think or if you
         * feel like you have
         * a good idea just throw it in
         */

        int numPlayers = 0;
        while (true) {
            try {
                String input = ConsoleHelper.getInput("Enter number of players (1 or 2): ");
                numPlayers = Integer.parseInt(input);
                if (numPlayers == 1 || numPlayers == 2) {
                    break;
                }
                System.out.println("Please enter 1 or 2.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
            }
        }

        for (int i = 1; i <= numPlayers; i++) {
            String name = ConsoleHelper.getInput("Enter name for Player " + i + ": ");
            // ask for what kind of ship factory they want.
            ShipFactory shipFactory;
            while (true) {
                String factoryChoice = (ConsoleHelper
                        .getInput("Choose a ship factory, press M for manual and A for automatic:")).toLowerCase();
                if (factoryChoice.equals("a")) {
                    shipFactory = new AutomaticShipFactory();
                    break;
                } else if (factoryChoice.equals("m")) {
                    shipFactory = new ManualShipFactory();
                    break;
                } else {
                    System.out.println("Invalid input, please enter A for automatic or M for Manual.");
                }

            }

            Player player = new HumanPlayer(name, shipFactory);
            players.add(player);
        }

        // For a single player game, create an AI opponent
        if (numPlayers == 1) {
            ShipFactory aiShipFactory = new AutomaticShipFactory();
            Player ai = new EasyAIPlayer(aiShipFactory);
            players.add(ai);
            System.out.println("An Easy AI opponent has been added!");
        }
    }

    public void printGameOver() {
        System.out.println(
                        "  /$$$$$$   /$$$$$$  /$$      /$$ /$$$$$$$$  /$$$$$$  /$$    /$$ /$$$$$$$$ /$$$$$$$ \n" +
                        " /$$__  $$ /$$__  $$| $$$    /$$$| $$_____/ /$$__  $$| $$   | $$| $$_____/| $$__  $$\n" +
                        "| $$  \\__/| $$  \\ $$| $$$$  /$$$$| $$      | $$  \\ $$| $$   | $$| $$      | $$  \\ $$\n" +
                        "| $$ /$$$$| $$$$$$$$| $$ $$/$$ $$| $$$$$   | $$  | $$|  $$ / $$/| $$$$$   | $$$$$$$/\n" +
                        "| $$|_  $$| $$__  $$| $$  $$$| $$| $$__/   | $$  | $$ \\  $$ $$/ | $$__/   | $$__  $$\n" +
                        "| $$  \\ $$| $$  | $$| $$\\  $ | $$| $$      | $$  | $$  \\  $$$/  | $$      | $$  \\ $$\n" +
                        "|  $$$$$$/| $$  | $$| $$ \\/  | $$| $$$$$$$$|  $$$$$$/   \\  $/   | $$$$$$$$| $$  | $$\n" +
                        " \\______/ |__/  |__/|__/     |__/|________/ \\______/     \\_/    |________/|__/  |__/\n" +
                        "                                                                                     \n" +
                        "                                                                                     \n" +
                        "                                                                                     ");

    }

}
