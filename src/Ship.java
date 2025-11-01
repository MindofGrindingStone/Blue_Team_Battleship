import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ship {
    private String name;
    private Set<Coordinate> coords;
    private Set<Coordinate> hits;

    public Ship(int length, String name, Set<Coordinate> coords) {
        this.name = (name == null) ? "" : name.trim();
        this.coords = (coords == null) ? new LinkedHashSet<>() : new LinkedHashSet<>(coords);
        this.hits = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Coordinate> getCoords() {
        return Collections.unmodifiableSet(coords);
    }

    public Boolean isSunk() {
        return hits.containsAll(coords);
    }

    public void registerHitAt(Coordinate coord) {
        if (coords.contains(coord)) {
            hits.add(coord);
        }
    }
}
