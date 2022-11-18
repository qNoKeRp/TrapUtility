package qnokerp.trapka;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import qnokerp.trapka.utils.CM;
import qnokerp.trapka.place.EventListener;
import qnokerp.trapka.utils.Cuboid;
import qnokerp.trapka.utils.Itm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static qnokerp.trapka.items.NewItems.PlastItemStack;
import static qnokerp.trapka.items.NewItems.TrapkaItemStack;
import static qnokerp.trapka.place.SetBlocks.*;


public final class Trapka extends JavaPlugin {

    private static Trapka instance;
    @Override
    public void onEnable() {
        HashMap<Location, Material> blocks = new HashMap<Location, Material>();
        List<Cuboid> cuboids = new ArrayList<>();
        HashMap<String, Itm> items = new HashMap<String, qnokerp.trapka.utils.Itm>();

        instance = this;
        CM.setupCooldown();

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

            Material material = blocks.get(location);

            if(material != null) {
                location.getBlock().setType(material);
            }

        }
    }
}
