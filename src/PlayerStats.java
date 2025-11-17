public class PlayerStats {
    private int shotsFired;
    private int hits;
    private int misses;
    
    

    

    public PlayerStats() {
        this.shotsFired = 0;
        this.hits = 0;
        this.misses = 0;
    
    }
    public int getShotsFired() {
        return shotsFired;
    }
    public int getHits() {
        return hits;
    }
    public int getMisses() {
        return misses;
    }
    public void addShotFired(){
        shotsFired++;
    }
    public void addHit(){
        hits++;
    }
    public void addMiss(){
        misses++;
    }
    public float getAccuracy(){
        float accuracy = ((hits/shotsFired) * 100);
        return accuracy;
    }
    

}
