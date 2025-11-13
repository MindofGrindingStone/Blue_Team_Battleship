import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EasyAIPlayer extends Player {

    private List<Coordinate> availableShots;

    public EasyAIPlayer(String name, ShipFactory shipFactory) {
        super(name, shipFactory);

        this.availableShots = new ArrayList<>();

        // Pre-populate all coordinates (10x10 grid)
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                availableShots.add(new Coordinate(row, col));
            }
        }

        // Shuffle coordinates for random selection
        Collections.shuffle(availableShots);
    }

    // Getter for available shots list
    public List<Coordinate> getAvailableShots() {
        return availableShots;
    }

    // Methods to implement?
    public Coordinate takeShot() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void receiveShot(Coordinate coord) {
        oceanGrid.receiveShot(coord);
        
    }

    public void receiveShotResult(Coordinate coord, ShotResult result) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
