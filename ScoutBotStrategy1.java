import LepinskiEngine.*;
import java.util.List;
import java.util.Random;

public class ScoutBotStrategy1 extends BotStrategy
{
	
    public ScoutBotStrategy1() {
		// sets up the random direction
		Random rand = new Random();
		//gets a list of directions
		List possibleDirections = cur_vision.getDirections();
		// gets the bots current location
		int xLoc = cur_vision.getX();
		int yLoc = cur_vision.getY();
    }
    
    public Command nextMove(Robot bot, List<Location> cur_vision, Map map) {
		// if the direction is both possible AND unexplored, then the bot will go that way
		// the bot checks three away from the current posistion in each direction
		if (possibleDirections.contains("North") && Map.getLabel(xLoc , yLoc + 3) == 0) {
			return new CommandMove(bot,DirType.North);
		}
		else if (possibleDirections.contains("East")&& Map.getLabel(xLoc + 3, yLoc) == 0) {
			return new CommandMove(bot,DirType.East);
		}
		else if (possibleDirections.contains("South") && Map.getLabel(xLoc, yLoc - 3) == 0) {
			return new CommandMove(bot,DirType.South);
		}
		else if (possibleDirections.contains("West") && Map.getLabel(xLoc - 3, yLoc) == 0) {
			return new CommandMove(bot,DirType.West);
		}
		// if all of the directions are explored then the bot picks a random direction and moves that way
		else{
			// direction is based on the list of possible directions
			int randomIndex= rand.nextInt(possibleDirections.size);
			String direction = possibleDirections.get(randomIndex);
			if (direction = "North") {
				return new CommandMove(bot, DirType.North);
			}
			if (direction = "East") {
				return new CommandMove(bot, DirType.East);
			}
			if (direction = "South") {
				return new CommandMove(bot, DirType.South);
			}
			if (direction = "West") {
				return new CommandMove(bot, DirType.West);
			}
		}
    }
}
