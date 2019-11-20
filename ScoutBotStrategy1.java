import LepinskiEngine.*;
import java.util.List;

public class ScoutBotStrategy1 extends BotStrategy
{
    public ScoutBotStrategy1() {
        //stubbed
    }
    
    public Command nextMove(Robot bot, List<Location> cur_vision, Map map) {
        //stubbed
        return new CommandMove(bot,DirType.North);
    }
}
