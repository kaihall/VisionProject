import LepinskiEngine.*;
import java.util.List;

public class CoinBotStrategy extends BotStrategy
{
   public CoinBotStrategy() {
       //stubbed
    }

   public Command nextMove(Robot bot, List<Location> cur_vision, Map map) {
       //stubbed 
       return new CommandCoin(bot);
   }
}