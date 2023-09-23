package space.yurisi.universeeconomy.command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Color;
import org.bukkit.command.CommandExecutor;
import space.yurisi.universeeconomy.UniverseEconomyAPI;

public abstract class BaseCommand implements CommandExecutor {
    protected final String unit = UniverseEconomyAPI.getInstance().getUnit();

    protected final String title = "[銀行AI] ";

    protected Component getSuccessMessage(String text) {
        return Component.text(title + text).color(TextColor.color(Color.GREEN.asRGB()));
    }

    protected Component getErrorMessage(String text) {
        return Component.text(title + text).color(TextColor.color(Color.RED.asRGB()));
    }
}
