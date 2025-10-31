import java.util.*;

public class Ship {
    private String name;
    private Set<Coordinate> coords = new LinkedHashSet<>();
    private Set<Coordinate> hits   = new HashSet<>();

    public Ship(String name) {
        this.name = name;
    }

    public String getName() { 
        return name; 
    }
    public int getLength() { 
        Integer len = Constants.getSHIP_SPECS().get(name);
        return len == null ? 0 : len;
    }
    public Set<Coordinate> getCoordinates() { 
        return Collections.unmodifiableSet(coords); 
    }

    public Set<Coordinate> getCoords() {
        return getCoordinates();
    }
    public void addCoordinate(Coordinate c) { 
        coords.add(c); 
    }

    public void registerHit(Coordinate c) {
        if (coords.contains(c)) hits.add(c);
    }

 
    public void registerHitAt(Coordinate c) {
        registerHit(c);
    }

    public boolean isSunk() {
        return hits.size() == getLength();
    }
}
