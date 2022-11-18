package qnokerp.trapka.utils;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.entity.Player;

public class CM {

    public static HashMap<UUID, Double> plastcooldown, trapkacooldown;

    public static void setupCooldown(){
        plastcooldown = new HashMap<>();
        trapkacooldown = new HashMap<>();

    }

    //setCooldown
    public static void setPlastCooldown(Player player, int Seconds) {
        double delay = System.currentTimeMillis() + (Seconds*1000);
        plastcooldown.put(player.getUniqueId(), delay);

    }

    public static void setTrapkaCooldown(Player player, int seconds) {
        double delay = System.currentTimeMillis() + (seconds * 1000);
        trapkacooldown.put(player.getUniqueId(), delay);

    }


    //getCooldown
    public static int getPlastCooldown(Player player){
        return Math.toIntExact(Math.round((plastcooldown.get(player.getUniqueId()) - System.currentTimeMillis())/1000));
    }

    public static int getTrapkaCooldown(Player player){
        return Math.toIntExact(Math.round((trapkacooldown.get(player.getUniqueId()) - System.currentTimeMillis())/1000));
    }



    //checkCooldown
    public static boolean checkPlastCooldown(Player player){
        if(!plastcooldown.containsKey(player.getUniqueId()) || plastcooldown.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }

    public static boolean checkTrapkaCooldown(Player player){
        if(!trapkacooldown.containsKey(player.getUniqueId()) || trapkacooldown.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }

}
