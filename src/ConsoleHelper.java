import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String getInput(final String prompt) {
        String inStr = "";
        System.out.print(prompt);
        try {
            inStr = reader.readLine();
        } catch (final IOException e) {
            System.out.println("Error reading from user");
        }
        return inStr;
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
            } else {
            // Linux / macOS / Unix-like
            new ProcessBuilder("clear")
                    .inheritIO()
                    .start()
                    .waitFor();
            }
        
        } catch (final Exception e) {
            // Handle exceptions, e.g., if the command fails
            System.err.println("Error clearing console: " + e.getMessage());
        }
    }
}
