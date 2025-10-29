import java.util.*;

public final class Constants {
    private static final Map<String, Integer> SHIP_SPECS = Map.of(
        "Carrier", 5,
        "Battleship",4,
        "Destroyer" ,3,
        "Submarine", 3,
        "Patrol Boat",2
    );
    public static Map<String, Integer> getSHIP_SPECS(){
        return SHIP_SPECS;
    }

}