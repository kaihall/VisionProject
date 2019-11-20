import LepinskiEngine.*;
import java.util.List;

public class ScoutBotStrategy2 extends BotStrategy
{
    public ScoutBotStrategy2() {
        //stubbed
    }

    public Command nextMove(Robot bot, List<Location> cur_vision, Map map) {
        //stubbed
        return new CommandMove(bot,DirType.South);
    }
}
