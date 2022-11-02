package qnokerp.trapka;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import static qnokerp.trapka.SetBlocks.SetPlast;
import static qnokerp.trapka.SetBlocks.SetTrapka;
import static qnokerp.trapka.NewItems.PlastItemStack;
import static qnokerp.trapka.NewItems.TrapkaItemStack;

public class EventListener implements Listener  {    //Использование пластов и трапок

    @EventHandler
    public void onItemClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        try {
            if (player.getItemInHand().getItemMeta().equals(TrapkaItemStack().getItemMeta())) {
                SetTrapka(player);
            }

            if (player.getItemInHand().getItemMeta().equals(PlastItemStack().getItemMeta())) {
                SetPlast(player);
            }

        } catch (Exception e) {
            System.out.println("Ошибка в ивентлистенере");
        }

    }
}