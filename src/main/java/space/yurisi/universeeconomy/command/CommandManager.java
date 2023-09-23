package space.yurisi.universeeconomy.command;

import space.yurisi.universeeconomy.UniverseEconomy;

public class CommandManager {
    public CommandManager(UniverseEconomy main) {
        init(main);
    }

    private void init(UniverseEconomy main) {
        main.getCommand("money").setExecutor(new moneyCommand());
        main.getCommand("mymoney").setExecutor(new mymoneyCommand());
        main.getCommand("addmoney").setExecutor(new addmoneyCommand());
        main.getCommand("reducemoney").setExecutor(new reducemoneyCommand());
        main.getCommand("pay").setExecutor(new payCommand());
        main.getCommand("seemoney").setExecutor(new seemoneyCommand());
        main.getCommand("setmoney").setExecutor(new setmoneyCommand());
    }
}
