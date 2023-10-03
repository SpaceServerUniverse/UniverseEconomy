package space.yurisi.universeeconomy.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import space.yurisi.universecore.exception.MoneyNotFoundException;
import space.yurisi.universecore.exception.UserNotFoundException;
import space.yurisi.universeeconomy.UniverseEconomyAPI;
import space.yurisi.universeeconomy.exception.ParameterException;

import static java.lang.Long.parseLong;

public class setmoneyCommand extends BaseCommand {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            return false;
        }
        if (args.length != 2) {
            return false;
        }

        Player to_player = Bukkit.getServer().getPlayerExact(args[0]);

        if (to_player == null) {
            player.sendMessage(getErrorMessage("ユーザーが見つかりませんでした。サーバー内に存在しますか？"));
            return true;
        }

        try {
            Long amount = parseLong(args[1]);
            UniverseEconomyAPI.getInstance().setMoney(to_player, amount, "UniverseEconomy setmoney command 実行者:" + player.getName());
            player.sendMessage(getSuccessMessage(to_player.getName() + "のお金を" + amount + unit + "にセットしました。"));
        } catch (NumberFormatException e) {
            return false;
        } catch (UserNotFoundException e) {
            player.sendMessage(getErrorMessage("ユーザーデータが存在しないようです。管理者に報告してください。 コード-UES1"));
        } catch (MoneyNotFoundException e) {
            player.sendMessage(getErrorMessage("マネーデータが存在しないようです。管理者に報告してください。 コード-UES2"));
        } catch (ParameterException e) {
            player.sendMessage(getErrorMessage("お金はマイナスを指定できません。"));
        }
        return true;
    }
}
