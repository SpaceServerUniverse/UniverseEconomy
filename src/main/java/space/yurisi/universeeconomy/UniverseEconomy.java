package space.yurisi.universeeconomy;

import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import space.yurisi.universecore.UniverseCoreAPI;
import space.yurisi.universecore.database.DatabaseManager;
import space.yurisi.universeeconomy.command.CommandManager;
import space.yurisi.universeeconomy.event.EventManager;
import space.yurisi.universeeconomy.file.Config;

public final class UniverseEconomy extends JavaPlugin {

    private DatabaseManager databaseManager;

    private Config config;
    @Override
    public void onEnable() {
        this.config = new Config(this);
        this.databaseManager = UniverseCoreAPI.getInstance().getDatabaseManager();
        new UniverseEconomyAPI(this.databaseManager, getPluginConfig());
        new EventManager(this);
        new CommandManager(this);
    }

    public DatabaseManager getDatabaseManager() {
        return this.databaseManager;
    }

    public @NotNull Config getPluginConfig() {
        return this.config;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
