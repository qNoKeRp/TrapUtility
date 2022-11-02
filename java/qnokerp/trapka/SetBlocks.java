package qnokerp.trapka;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import java.util.HashMap;

public class SetBlocks {
    static HashMap<Location, Material> blocks = new HashMap<Location, Material>();
    public static void SetPlast(Player player) {

        Location center = player.getLocation();

        int xway = (int) center.getX() - 2;
        int yway = (int) center.getY() - 2;
        int zway = (int) center.getZ() - 2;

        int x = xway;
        int y = yway;
        int z = zway;

        for (int a = 1; a <= 2; a++) {      //Создание пласта и запись в кеш удаленных блоков
            for (int b = 1; b <= 5; b++) {
                for (int c = 1; c <= 5; c++) {
                    Block block = new Location(player.getWorld(), x, y, z).getBlock();



                    if (block.getType() != Material.OBSIDIAN)
                    {
                        blocks.put(new Location(player.getWorld(), x, y, z), block.getType());
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "fill " + x + " " + y + " " + z + " " + x + " " + y + " " + z + " " + "minecraft:obsidian");

                    }


                    z = z + 1;
                }
                x = x + 1;
                z = zway;
            }
            y = y + 1;
            x = xway;
        }

        player.getServer().getScheduler().scheduleSyncDelayedTask(Trapka.getInstance(), new Runnable() {     //Таймер по истечению которого удалится пласт и записи в кеше
            @Override
            public void run() {

                int XWAY = (int) center.getX() - 2;
                int YWAY = (int) center.getY() - 2;
                int ZWAY = (int) center.getZ() - 2;

                int x = XWAY;
                int y = YWAY;
                int z = ZWAY;



                for (int a = 1; a <= 2; a++) {
                    for (int b = 1; b <= 5; b++) {
                        for (int c = 1; c <= 5; c++) {
                            Location blocklock = new Location(player.getWorld(), x, y, z);
                            String material = toString().valueOf(blocks.get(blocklock)).toLowerCase();

                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "fill " + x + " " + y + " " + z + " " + x + " " + y + " " + z + " " + "minecraft:" + material);

                            blocks.remove(blocklock);

                            z = z + 1;
                        }
                        x = x + 1;
                        z = ZWAY;
                    }
                    y = y + 1;
                    x = XWAY;
                }


            }
        }, 60);
    }


    public static void SetTrapka(Player player) {

        Location center = player.getLocation();

        int XWAY = (int) center.getX() - 2;
        int YWAY = (int) center.getY() - 1;
        int ZWAY = (int) center.getZ() - 2;

        int x = XWAY;
        int y = YWAY;
        int z = ZWAY;

        for (int a = 1; a <= 5; a++) {      //Создание трапки и запись в кеш удаленных блоков
            for (int b = 1; b <= 5; b++) {
                for (int c = 1; c <= 5; c++) {
                    Block block = new Location(player.getWorld(), x, y, z).getBlock();

                    blocks.put(new Location(player.getWorld(), x, y, z), block.getType());

                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "fill " + x + " " + y + " " + z + " " + x + " " + y + " " + z + " " + "minecraft:obsidian");
                    z = z + 1;
                }
                x = x + 1;
                z = ZWAY;
            }
            y = y + 1;
            x = XWAY;
        }

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "fill " + (XWAY + 1)  + " " + (YWAY + 1) + " " + (ZWAY + 1) + " " + (XWAY + 3) + " " + (YWAY + 3) + " " + (ZWAY + 3) + " " + "air");

        player.getServer().getScheduler().scheduleSyncDelayedTask(Trapka.getInstance(), new Runnable() {      //Таймер по истечению которого удалится трапка и записи в кеше
            @Override
            public void run() {

                int XWAY = (int) center.getX() - 2;
                int YWAY = (int) center.getY() - 1;
                int ZWAY = (int) center.getZ() - 2;

                int x = XWAY;
                int y = YWAY;
                int z = ZWAY;

                for (int a = 1; a <= 5; a++) {
                    for (int b = 1; b <= 5; b++) {
                        for (int c = 1; c <= 5; c++) {
                            Location blocklock = new Location(player.getWorld(), x, y, z);
                            String material = toString().valueOf(blocks.get(blocklock)).toLowerCase();

                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "fill " + x + " " + y + " " + z + " " + x + " " + y + " " + z + " " + "minecraft:" + material);

                            blocks.remove(blocklock);

                            z = z + 1;
                        }
                        x = x + 1;
                        z = ZWAY;
                    }
                    y = y + 1;
                    x = XWAY;
                }


            }
        }, 60);

        }


}
