package space.yurisi.universeeconomy;

import org.bukkit.plugin.java.JavaPlugin;
import space.yurisi.universecore.UniverseCoreAPI;
import space.yurisi.universecore.database.DatabaseManager;
import space.yurisi.universeeconomy.event.EventManager;

public final class UniverseEconomy extends JavaPlugin {

    private DatabaseManager databaseManager;
    @Override
    public void onEnable() {
        this.databaseManager = UniverseCoreAPI.api().getDatabaseManager();
        new EventManager(this);
    }

    public DatabaseManager getDatabaseManager() {
        return databaseManager;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
