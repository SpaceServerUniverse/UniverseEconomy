package space.yurisi.universeeconomy.event;

import org.bukkit.Bukkit;
import space.yurisi.universeeconomy.UniverseEconomy;
import space.yurisi.universeeconomy.event.player.LoginEvent;

public class EventManager {

    public EventManager(UniverseEconomy universeEconomy){
        init(universeEconomy);
    }

    private void init(UniverseEconomy universeEconomy){
        Bukkit.getPluginManager().registerEvents(new LoginEvent(universeEconomy.getDatabaseManager()), universeEconomy);
    }
}
