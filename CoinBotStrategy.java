import LepinskiEngine.*;
import java.util.List;

public class CoinBotStrategy extends BotStrategy
{
   public CoinBotStrategy() {
    }

    //this returns a float to be multiplied to the pathlength. This makes the coinbot more likely to seek
    //groups of coins, as opposed to just the closest coin.
    private float weightDecision(Location loc, Map m){
        count = 0;
        criticalval = (m.getMaxX() + m.getMaxY())/2/5;
        coins = m.coinPaths(loc);
        for(List<Location> lstloc : coins){
            if(lstloc[lstloc.length-1].getX() - loc.getX() < criticalval && lstloc[lstloc.length-1].getY() - loc.getY() < criticalval){
                count += 1
            }
        }   
        return exp(.8, count) //.8^count
    }

   public Command nextMove(Robot bot, List<Location> cur_vision, Map map) {
       map.update(cur_vision)
       int currentmin = 50;
       List retlist;
       DirType direction;
       if(map.onCoin(bot) != false){
           return new CommandCoin(bot); //I believe this is correct for picking up the coin?
       }
       else{
           for(List<Location> lloc : map.coinPaths(map.getBotLocation(bot))){
               weightedlength = weightdecision(lloc[lloc.length-1], map) * lloc.length();
               if(weightedlength < currentmin){
                    currentmin = lloc.length();
                    retlist = lloc;
               }
           }
           nextsquare = retlist[0]
           if(nextsquare.getX() == map.getBotLocation().getX()+1)
               direction = DirType.East;
           else if(nextsquare.getX() == map.getBotLocation().getX() - 1)
                direction = DirType.West;
            else if(nextsquare.getY() == map.getBotLocation().getX() - 1)
                direction = DirType.North;
            else{
                direction = DirType.South;
            }
       }
       return new CommandMove(bot, direction)
   }
}