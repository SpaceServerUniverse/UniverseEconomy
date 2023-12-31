package space.yurisi.universeeconomy.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import space.yurisi.universecore.exception.MoneyNotFoundException;
import space.yurisi.universecore.exception.UserNotFoundException;
import space.yurisi.universeeconomy.UniverseEconomyAPI;

public class seemoneyCommand extends BaseCommand {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }

        if (args.length != 1) {
            return false;
        }

        try {
            Long money = UniverseEconomyAPI.getInstance().getMoneyFromUserName(args[0]);
            player.sendMessage(getSuccessMessage(args[0] + "の所持金 :" + money.toString() + this.unit));
        } catch (UserNotFoundException e) {
            player.sendMessage(getErrorMessage("プレイヤーが見つかりませんでした。"));
        } catch (MoneyNotFoundException e) {
            player.sendMessage(getErrorMessage("プレイヤーのマネーデータが見つかりませんでした。"));
        }
        return true;
    }
}
