
import java.util.List;


public class Menu {

    private List<Player> players = new java.util.ArrayList<>();
    private Game game;

    private void greetUser() {
        System.out.println("\r\n" + //
                        "\r\n" + //
                        " ___       __   _______   ___       ________  ________  _____ ______   _______                              \r\n" + //
                        "|\\  \\     |\\  \\|\\  ___ \\ |\\  \\     |\\   ____\\|\\   __  \\|\\   _ \\  _   \\|\\  ___ \\                             \r\n" + //
                        "\\ \\  \\    \\ \\  \\ \\   __/|\\ \\  \\    \\ \\  \\___|\\ \\  \\|\\  \\ \\  \\\\\\__\\ \\  \\ \\   __/|                            \r\n" + //
                        " \\ \\  \\  __\\ \\  \\ \\  \\_|/_\\ \\  \\    \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\\\|__| \\  \\ \\  \\_|/__                          \r\n" + //
                        "  \\ \\  \\|\\__\\_\\  \\ \\  \\_|\\ \\ \\  \\____\\ \\  \\____\\ \\  \\\\\\  \\ \\  \\    \\ \\  \\ \\  \\_|\\ \\                         \r\n" + //
                        "   \\ \\____________\\ \\_______\\ \\_______\\ \\_______\\ \\_______\\ \\__\\    \\ \\__\\ \\_______\\                        \r\n" + //
                        "    \\|____________|\\|_______|\\|_______|\\|_______|\\|_______|\\|__|     \\|__|\\|_______|                        \r\n" + //
                        "                                                                                                            \r\n" + //
                        "                                                                                                            \r\n" + //
                        "                                                                                                            \r\n" + //
                        " _________  ________                                                                                        \r\n" + //
                        "|\\___   ___\\\\   __  \\                                                                                       \r\n" + //
                        "\\|___ \\  \\_\\ \\  \\|\\  \\                                                                                      \r\n" + //
                        "     \\ \\  \\ \\ \\  \\\\\\  \\                                                                                     \r\n" + //
                        "      \\ \\  \\ \\ \\  \\\\\\  \\                                                                                    \r\n" + //
                        "       \\ \\__\\ \\ \\_______\\                                                                                   \r\n" + //
                        "        \\|__|  \\|_______|                                                                                   \r\n" + //
                        "                                                                                                            \r\n" + //
                        "                                                                                                            \r\n" + //
                        "                                                                                                            \r\n" + //
                        " ________  ________  _________  _________  ___       _______   ________  ___  ___  ___  ________  ___       \r\n" + //
                        "|\\   __  \\|\\   __  \\|\\___   ___\\\\___   ___\\\\  \\     |\\  ___ \\ |\\   ____\\|\\  \\|\\  \\|\\  \\|\\   __  \\|\\  \\      \r\n" + //
                        "\\ \\  \\|\\ /\\ \\  \\|\\  \\|___ \\  \\_\\|___ \\  \\_\\ \\  \\    \\ \\   __/|\\ \\  \\___|\\ \\  \\\\\\  \\ \\  \\ \\  \\|\\  \\ \\  \\     \r\n" + //
                        " \\ \\   __  \\ \\   __  \\   \\ \\  \\     \\ \\  \\ \\ \\  \\    \\ \\  \\_|/_\\ \\_____  \\ \\   __  \\ \\  \\ \\   ____\\ \\  \\    \r\n" + //
                        "  \\ \\  \\|\\  \\ \\  \\ \\  \\   \\ \\  \\     \\ \\  \\ \\ \\  \\____\\ \\  \\_|\\ \\|____|\\  \\ \\  \\ \\  \\ \\  \\ \\  \\___|\\ \\__\\   \r\n" + //
                        "   \\ \\_______\\ \\__\\ \\__\\   \\ \\__\\     \\ \\__\\ \\ \\_______\\ \\_______\\____\\_\\  \\ \\__\\ \\__\\ \\__\\ \\__\\    \\|__|   \r\n" + //
                        "    \\|_______|\\|__|\\|__|    \\|__|      \\|__|  \\|_______|\\|_______|\\_________\\|__|\\|__|\\|__|\\|__|        ___ \r\n" + //
                        "                                                                 \\|_________|                          |\\__\\\r\n" + //
                        "                                                                                                       \\|__|\r\n" + //
                        "\r\n" + //
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
                        ConsoleHelper.getInput("0. Replay\n1. Start New Game\n2. Tutorial\n3. Exit\nEnter Here: ")
                                .charAt(0));
                while (true) {
                    if (choice < 0 || choice > 3) {
                        System.out.println("Invalid choice, please try again.");
                    } else {
                        chooseStartOption(choice);
                        break;
                    }
                }
            }
        }
    }

    private void chooseStartOption(int choice) {
        switch (choice) {
            case 0:
                game = new Game(players);
                game.play();
                break;
            case 1:
                players.clear();
                chooseNumberOfPlayers();
                game = new Game(players);
                game.play();
                break;
            case 2:
                players.clear();
                chooseNumberOfPlayers(); // needs to be revisited tutorial as a subclass of game
                game = new Game(players);
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
        /*  this method needs to choose the number of players then create them I think
        also I'm not sure what to do for the tutorial option up above, I am currently calling this
        right before creating a new game to play the tutorial, maybe we need another method to call
        that would create a tutorial player? Let me know what you think or if you feel like you have
        a good idea just throw it in*/
        

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
            Player player = new Player(name);
            players.add(player);
        }

        // For a single player game, create an AI opponent
        if (numPlayers == 1) {
            Player ai = new Player("Computer");
            players.add(ai);
            System.out.println("A computer opponent has been added!");
        }
    }

}

