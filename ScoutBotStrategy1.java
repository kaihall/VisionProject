import LepinskiEngine.*;
import java.util.List;
import java.util.Random;

public class ScoutBotStrategy1 extends BotStrategy
{
    Random rand;
    
    public ScoutBotStrategy1() {
        // creates a new instance of random
        rand = new Random();
    }
    
    public Command nextMove(Robot bot, List<Location> cur_vision, Map map) {
        //gets the bot's current location
        Location cur_loc = map.getBotLocation(bot);
        
        //gets a list of directions
        List<DirType> possibleDirections = cur_loc.getDirections();
        
        // gets the bots current location in the maze
        int xLoc = cur_loc.getX();
        int yLoc = cur_loc.getY();
        
        // if the direction is both possible AND unexplored, then the bot will go that way
        // the bot checks three away from the current posistion in each direction
        if (possibleDirections.contains(DirType.North) && map.getLabel(xLoc , yLoc + 3) == Map.UNSCANNED) {
            return new CommandMove(bot,DirType.North);
        }
        else if (possibleDirections.contains(DirType.East)&& map.getLabel(xLoc + 3, yLoc) == Map.UNSCANNED) {
            return new CommandMove(bot,DirType.East);
        }
        else if (possibleDirections.contains(DirType.South) && map.getLabel(xLoc, yLoc - 3) == Map.UNSCANNED) {
            return new CommandMove(bot,DirType.South);
        }
        else if (possibleDirections.contains(DirType.West) && map.getLabel(xLoc - 3, yLoc) == Map.UNSCANNED) {
            return new CommandMove(bot,DirType.West);
        }
        // if all of the directions are explored then the bot picks a random direction and moves that way
        else{
            // direction is based on the list of possible directions
            int randomIndex = rand.nextInt(possibleDirections.size());
            DirType direction = possibleDirections.get(randomIndex);
            return new CommandMove(bot,direction);
        }
    }
}
