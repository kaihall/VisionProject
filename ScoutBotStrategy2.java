import LepinskiEngine.*;
import java.util.List;
import java.lang.Math;
import java.util.Random;


public class ScoutBotStrategy2 extends BotStrategy
{
    public ScoutBotStrategy2() {
	//Sets up random direction
	Random r= new Random();
	//Gets the possible directions
	List posDirex = cur_vision.getDirections();
	//gets location
	int xLoc = cur_vision.getX();
	int xLoc = cur_vision.getX();
    }

    public Command nextMove(Robot bot, List<Location> cur_vision, Map map) {
        //Creates done condition
	//Becomes true when there are no unexplored cells
	boolean done = false;
	int Tx = xLoc;
	int Ty = yLoc;

	//While the done condition remains false, a random target location is created in an unexplored cell
	while(done == false){
	    while(Map.getLable(Tx,Ty)!= 0){
		Tx = (int)(Math.random()* max_x);
		Ty = (int)(Math.random()* max_y);
	    }

	    //The bot will then go in a random direction available to it until it reaches the target location
	    while ((xLoc!=Tx)&&(yLoc!=Ty)){
		int randIndex = r.nextInt(posDirex.size);
		String direx = posDirex.get(randIndex);
		if (direx = "North"){
		    return new CommandMove(bot,DirType.North);
		}
		if (direx = "East"){
		    return new CommandMove(bot,DirType.East);
		}
		if (direx = "South"){
		    return new CommandMove(bot,DirType.South);
		}
		if (direx = "West"){
		    return new CommandMove(bot,DirType.West);
		}
	    }
	   
	    //Checks if all cells have been changed to Scanned
	    int doneCtr=0;

	    for(int i=0; i<=max_x; i++){
		for(int j=0; j<=max_y; j++){
		    if(Map.getLable(i,j)== 0){
			doneCtr=doneCtr+1;
		    }
		}
	    }
	    if(doneCtr == 0){
		done = true;
	    else{
		done = false;
	    }
	}
    }
}