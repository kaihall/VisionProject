import LepinskiEngine.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Map {
    //These are integers instead of enums so that strategies can use math to figure out where to go next
    public static final int DNE = -1;
    public static final int UNSCANNED = 0;
    public static final int SCANNED = 1;
    public static final int DEAD_END = 2;
    
    private int max_x, max_y;
    private int[][] labels;
    private ArrayList<ArrayList<Location>> map;
    private HashSet<Location> coins;
    private HashMap<Robot,Location> robots;
    
    public Map(int maze_x, int maze_y) {
        max_x = maze_x - 1;
        max_y = maze_y - 1;
        
        labels = new int[max_x][max_y];
        
        for (int i = 0; i <= max_x; i++) {
            map.add(new ArrayList<Location>());
            for (int j = 0; j <= max_y; j++) {
                map.get(i).add(null);
                labels[i][j] = UNSCANNED;
            }
        }
        
        coins = new HashSet<Location>();
        robots = new HashMap<Robot,Location>();
    }

    public void update(List<Location> info) {
        for (Location loc : info) {
            int x = loc.getX();
            int y = loc.getY();
            
            if (!loc.getCoins().isEmpty())
                coins.add(loc);
                
            for (Robot bot : loc.getRobots())
                robots.put(bot,loc);
                
            map.get(x).set(y,loc);
            
            if (labels[x][y] == 0)
                labels[x][y] = 1;
        }
    }
    
    public List<Location> findPath(Location here, Location there) {
        List<Location> path = new ArrayList<Location>();
        
        //stubbed
        
        return path;
    }
    
    public int getLabel(Location loc) {
        if (loc == null) return DNE;
        return labels[loc.getX()][loc.getY()];
    }
    
    public int getLabel(int x, int y) {
        if (x > max_x || y > max_y) return DNE;
        return labels[x][y];
    }
    
    public void setLabel(Location loc, int label) {
        if (loc != null) 
            labels[loc.getX()][loc.getY()] = label;
    }
    
    public void setLabel(int x, int y, int label) {
        if (x <= max_x && y <= max_y) {
            labels[x][y] = label;
        }
    }
    
    public Location getBotLocation(Robot bot) {
        return robots.get(bot);
    }
    
    public boolean onCoin(Robot bot) {
        return !getBotLocation(bot).getCoins().isEmpty();
    }
    
    public List<List<Location>> coinPaths(Location here) {
        List<List<Location>> paths = new ArrayList<List<Location>>();
        
        for (Location loc : coins)
            paths.add(findPath(here,loc));
        
        return paths;
    }
    
    public int getMaxX() {
        return max_x;
    }
    
    public int getMaxY() {
        return max_y;
    }
}
