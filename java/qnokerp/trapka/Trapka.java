package qnokerp.trapka;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import static qnokerp.trapka.SetBlocks.blocks;
import static qnokerp.trapka.NewItems.PlastItemStack;
import static qnokerp.trapka.NewItems.TrapkaItemStack;


public final class Trapka extends JavaPlugin {

    private static Trapka instance;
    @Override
    public void onEnable() {
        instance = this;

        Bukkit.getPluginManager().registerEvents(new EventListener(), this);

        getCommand("get").setExecutor(new CommandExecutor() {      //Выдача трапок и пластов
            @Override
            public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

                if (args[0].equalsIgnoreCase("trapka")) {
                    Player player = (Player) sender;
                    player.getInventory().addItem(TrapkaItemStack());
                }

                if (args[0].equalsIgnoreCase("plast")) {
                    Player player = (Player) sender;
                    player.getInventory().addItem(PlastItemStack());

                }

                return true;
            }
        });

    }
    public static Trapka getInstance() { return instance; }

    @Override
    public void onDisable() {      //Удаление всех пластов и трапок при рестарте
        for (Location location : blocks.keySet()) {

            int x = (int) location.getX();
            int y = (int) location.getY();
            int z = (int) location.getZ();

            String material = toString().valueOf(blocks.get(location)).toLowerCase();

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "fill " + x + " " + y + " " + z + " " + x + " " + y + " " + z + " " + "minecraft:" + material);
        }
    }
}
