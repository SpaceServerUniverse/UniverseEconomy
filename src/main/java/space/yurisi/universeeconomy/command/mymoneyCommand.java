package space.yurisi.universeeconomy.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import space.yurisi.universecore.exception.MoneyNotFoundException;
import space.yurisi.universecore.exception.UserNotFoundException;
import space.yurisi.universeeconomy.UniverseEconomyAPI;

public class mymoneyCommand extends BaseCommand {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player player)){
            return false;
        }

        try {
            Long money = UniverseEconomyAPI.getInstance().getMoney(player);
            player.sendMessage(getSuccessMessage("貴方の所持金 :" + money.toString() + this.unit));
        } catch (UserNotFoundException e) {
            player.sendMessage(getErrorMessage("ユーザーデータが存在しないようです。管理者に報告してください。 コード-UEMY1"));
        } catch (MoneyNotFoundException e) {
            player.sendMessage(getErrorMessage("マネーデータが存在しないようです。管理者に報告してください。 コード-UEMY2"));
        }

        return true;
    }
}
