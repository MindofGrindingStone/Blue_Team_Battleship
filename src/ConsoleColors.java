// https://en.wikipedia.org/wiki/ANSI_escape_code#8-bit

public class ConsoleColors {
    // Reset
    public static final String RESET = "\033[0;38;5;123m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String MAGENTA = "\033[0;35m";  // MAGENTA
    public static final String CYAN = "\033[0;38;5;45m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE
    public static final String ORANGE = "\033[0;38;5;208m";   // ORANGE
    public static final String PINK = "\033[0;38;5;213m";   // PINK
    public static final String BROWN = "\033[0;38;5;130m";   // BROWN
    public static final String PURPLE = "\033[0;38;5;93m";   // PURPLE
    public static final String GREY = "\033[0;38;5;250m";   // GREY

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String MAGENTA_BOLD = "\033[1;35m"; // MAGENTA
    public static final String CYAN_BOLD = "\033[1;38;5;117m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
    public static final String ORANGE_BOLD = "\033[1;38;5;208m";   // ORANGE
    public static final String PINK_BOLD = "\033[1;38;5;213m";   // PINK
    public static final String BROWN_BOLD = "\033[1;38;5;130m";   // BROWN
    public static final String PURPLE_BOLD = "\033[1;38;5;93m";   // PURPLE
    public static final String GREY_BOLD = "\033[1;38;5;251m";   // GREY

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String MAGENTA_UNDERLINED = "\033[4;35m"; // MAGENTA
    public static final String CYAN_UNDERLINED = "\033[4;38;5;45m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE
    public static final String ORANGE_UNDERLINED = "\033[4;38;5;208m";   // ORANGE
    public static final String PINK_UNDERLINED = "\033[4;38;5;213m";   // PINK
    public static final String BROWN_UNDERLINED = "\033[4;38;5;130m";   // BROWN
    public static final String PURPLE_UNDERLINED = "\033[4;38;5;93m";   // PURPLE
    public static final String GREY_UNDERLINED = "\033[4;38;5;250m";   // GREY

    // Italicized
    public static final String BLACK_ITALICIZED = "\033[3;30m";  // BLACK
    public static final String RED_ITALICIZED = "\033[3;31m";    // RED
    public static final String GREEN_ITALICIZED = "\033[3;32m";  // GREEN
    public static final String YELLOW_ITALICIZED = "\033[3;33m"; // YELLOW
    public static final String BLUE_ITALICIZED = "\033[3;34m";   // BLUE
    public static final String MAGENTA_ITALICIZED = "\033[3;35m"; // MAGENTA
    public static final String CYAN_ITALICIZED = "\033[3;38;5;45m";   // CYAN
    public static final String WHITE_ITALICIZED = "\033[3;37m";  // WHITE
    public static final String ORANGE_ITALICIZED = "\033[3;38;5;208m";   // ORANGE
    public static final String PINK_ITALICIZED = "\033[3;38;5;213m";   // PINK
    public static final String BROWN_ITALICIZED = "\033[3;38;5;130m";   // BROWN
    public static final String PURPLE_ITALICIZED = "\033[3;38;5;93m";   // PURPLE
    public static final String GREY_ITALICIZED = "\033[3;38;5;250m";   // GREY

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String MAGENTA_BACKGROUND = "\033[45m"; // MAGENTA
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE
    public static final String ORANGE_BACKGROUND = "\033[0;48;5;208m";   // ORANGE
    public static final String PINK_BACKGROUND = "\033[0;48;5;213m";   // PINK
    public static final String BROWN_BACKGROUND = "\033[0;48;5;130m";   // BROWN
    public static final String PURPLE_BACKGROUND = "\033[0;48;5;93m";   // PURPLE
    public static final String GREY_BACKGROUND = "\033[0;48;5;250m";   // GREY

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String MAGENTA_BRIGHT = "\033[0;95m"; // MAGENTA
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String MAGENTA_BOLD_BRIGHT = "\033[1;95m";// MAGENTA
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String MAGENTA_BACKGROUND_BRIGHT = "\033[0;105m"; // MAGENTA
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
