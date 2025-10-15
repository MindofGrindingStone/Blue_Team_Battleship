public class Menu {

    public void greetUser(){
        System.out.println("Welcome to Battleship! Please choose from the following options:");
    }
    
    public void presentStartMenu() {
        greetUser();
        Integer choice = Character.getNumericValue(ConsoleHelper.getInput("1. Start New Game\n2. Tutorial\n3. Exit").charAt(0));
        while (true) {
        if (choice < 1 || choice > 3) {
        System.out.println("Invalid choice, please try again.");
        } else {
        chooseStartOption(choice);
        break;
        }
    }
    }

    public void chooseStartOption(int choice) {

    }

    public void chooseNumberOfPlayers() {

    }
}
