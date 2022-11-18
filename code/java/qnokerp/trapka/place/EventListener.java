package qnokerp.trapka.place;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import qnokerp.trapka.utils.CM;
import qnokerp.trapka.utils.Cuboid;

import static qnokerp.trapka.items.NewItems.PlastItemStack;
import static qnokerp.trapka.items.NewItems.TrapkaItemStack;
import static qnokerp.trapka.place.SetBlocks.*;

public class EventListener implements Listener  {    //Использование пластов и трапок

    @EventHandler
    public void onItemClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        ItemStack item = player.getInventory().getItemInHand();

        if(player.getItemInHand().getItemMeta() != null) {
            if (player.getItemInHand().getItemMeta().equals(TrapkaItemStack().getItemMeta())) {
                if (CM.checkTrapkaCooldown(player)) {

                    SetTrapka(player);
                    CM.setTrapkaCooldown(player, 3);
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 100.0F, 0.5F);

                    item.setAmount(item.getAmount() - 1);
                    player.getInventory().setItemInMainHand(item);

                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[Трапка] &fТы сможешь использовать трапку через &c" + CM.getTrapkaCooldown(player) + " &fсекунд"));
                }

            }

            if (player.getItemInHand().getItemMeta().equals(PlastItemStack().getItemMeta())) {
                if (CM.checkPlastCooldown(player)) {

                    SetPlast(player);
                    CM.setPlastCooldown(player, 1);
                    player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 100.0F, 0.9F);

                    item.setAmount(item.getAmount() - 1);
                    player.getInventory().setItemInMainHand(item);

                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6[Пласт] &fТы сможешь использовать пласт через &c" + CM.getPlastCooldown(player) + " &fсекунд"));
                }
            }
        }
    }

//    List<Material> triggerBlocks = Arrays.asList(Material.OBSIDIAN, Material.CRYING_OBSIDIAN, Material.POLISHED_BLACKSTONE_SLAB);

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        Location location = event.getBlock().getLocation();

        for (Cuboid cuboid : cuboids) {
            if(cuboid.isIn(location)) {
                event.setCancelled(true);
            }
        }

    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        Location location = event.getBlock().getLocation();

        for (Cuboid cuboid : cuboids) {
            if (cuboid.isIn(location)) {
                event.setCancelled(true);
            }
        }
    }
}