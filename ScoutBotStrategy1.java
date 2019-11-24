import LepinskiEngine.*;
import java.util.List;
import java.util.Random;

public class ScoutBotStrategy1 extends BotStrategy
{
	
    public ScoutBotStrategy1() {
		// creates a new instance of random
		Random rand = new Random();
    }
    
    public Command nextMove(Robot bot, List<Location> cur_vision, Map map) {
		//gets a list of directions
		List<DirType> possibleDirections = cur_vision.getDirections();
		
		// gets the bots current location in the maze
		int xLoc = cur_vision.getX();
		int yLoc = cur_vision.getY();
		
		// checks to see if theres only one possible direction to move in
		// if there is it'll mark that location as a dead end
		if (possibleDirections.size == 1){
			map.setLabel(xLoc, yLoc, 2);
		}
		
		// if the direction is both possible AND unexplored, then the bot will go that way
		// the bot checks three away from the current posistion in each direction
		if (possibleDirections.contains(DirType.North) && map.getLabel(xLoc , yLoc + 3) == 0) {
			return new CommandMove(bot,DirType.North);
		}
		else if (possibleDirections.contains(DirType.East)&& map.getLabel(xLoc + 3, yLoc) == 0) {
			return new CommandMove(bot,DirType.East);
		}
		else if (possibleDirections.contains(DirType.South) && map.getLabel(xLoc, yLoc - 3) == 0) {
			return new CommandMove(bot,DirType.South);
		}
		else if (possibleDirections.contains(DirType.West) && map.getLabel(xLoc - 3, yLoc) == 0) {
			return new CommandMove(bot,DirType.West);
		}
		// if all of the directions are explored then the bot picks a random direction and moves that way
		else{
			// direction is based on the list of possible directions
			int randomIndex= rand.nextInt(possibleDirections.size);
			String direction = possibleDirections.get(randomIndex);
			if (direction = DirType.North) {
				return new CommandMove(bot, DirType.North);
			}
			if (direction = DirType.East) {
				return new CommandMove(bot, DirType.East);
			}
			if (direction = DirType.South) {
				return new CommandMove(bot, DirType.South);
			}
			if (direction = DirType.West) {
				return new CommandMove(bot, DirType.West);
			}
		}
    }
}
