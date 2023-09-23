package space.yurisi.universeeconomy.file;

import org.bukkit.configuration.file.FileConfiguration;
import space.yurisi.universeeconomy.UniverseEconomy;

public class Config {

    private final UniverseEconomy main;

    private FileConfiguration config = null;

    public Config(UniverseEconomy main) {
        this.main = main;
        init();
    }

    private void init() {
        main.saveDefaultConfig();
        if (config != null) {
            main.reloadConfig();
        }
        this.config = main.getConfig();
    }

    public String getUnit() {
        return this.config.getString("settings.unit");
    }

    public Long getMax() {
        return this.config.getLong("setting.max");
    }
}
