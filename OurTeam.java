import LepinskiEngine.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class OurTeam implements PlayerTeam
{
    GameState cur_state;
    HashMap<Robot,BotStrategy> strats;
    Map map;
    
    public void startGame(List<Robot> bots, GameState state) {
        cur_state = state;
        for (Robot rob : bots)
            strats.put(rob, assignStrategy(rob));
        map = new Map(cur_state.maze_size_x, cur_state.maze_size_y);
    }
    
    public List<Command> requestCommands(List<Location> information, List<Robot> robotsAwaitingCommand, GameState state) {
        cur_state = state;
        map.update(information);
        
        List<Command> commands = new ArrayList<Command>();
        
        for (Robot bot : robotsAwaitingCommand)
            commands.add(strats.get(bot).nextMove(bot,information,map));
        
        return commands;
    }
    
    public static BotStrategy assignStrategy(Robot bot) {
        List<BotStrategy> strategies = BotStrategy.getValidStrategies(bot.getModel());
        return strategies.get(bot.getID()%strategies.size());
    }
}