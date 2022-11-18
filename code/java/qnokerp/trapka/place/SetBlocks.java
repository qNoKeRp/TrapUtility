package qnokerp.trapka.place;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import qnokerp.trapka.Trapka;
import qnokerp.trapka.utils.Cuboid;
import qnokerp.trapka.utils.Itm;
import static qnokerp.trapka.place.SetTrapkaDecoration.setTrapkaDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SetBlocks {
    public static HashMap<Location, Material> blocks = new HashMap<Location, Material>();

    public static List<Cuboid> cuboids = new ArrayList<>();
    public  static HashMap<String, Itm> items = new HashMap<String, qnokerp.trapka.utils.Itm>();
    public static void SetPlast(Player player) {

        Location center = player.getLocation();
        World world = player.getWorld();

        int xway = (int) center.getX() - 2;
        int yway = (int) center.getY() - 2;
        int zway = (int) center.getZ() - 2;

        int x = xway;
        int y = yway;
        int z = zway;

        Cuboid cuboid = new Cuboid(new Location(world, xway, yway, zway), new Location(world, xway+4, yway+2, zway+4));

        cuboids.add(cuboid);

        for (int a = 1; a <= 2; a++) {      //Создание пласта и запись в кеш удаленных блоков
            for (int b = 1; b <= 5; b++) {
                for (int c = 1; c <= 5; c++) {
                    Location location = new Location(world, x, y, z);
                    Block block = location.getBlock();
                    BlockState state = block.getState();


                    int rnum = (int) (Math.random() * 2);
                    Material blockType = null;
                    if(rnum == 1) {
                        blockType = Material.OBSIDIAN;
                    } else {
                        blockType = Material.CRYING_OBSIDIAN;
                    }


                    if(block.getType() != Material.OBSIDIAN & block.getType() != Material.CRYING_OBSIDIAN & block.getType() != Material.BLACKSTONE_SLAB) {
                        if (state instanceof Container) {
                            Container container = (Container) state;
                            Inventory inventory = container.getInventory();

                            for (int i = 0; i < inventory.getSize(); i++) {
                                ItemStack item = inventory.getContents()[i];

                                if (item != null) {
                                    Itm itm = new Itm(item.getItemMeta(), item.getType(), item.getAmount(), i);
                                    items.put(location.toString() + " " + i, itm);
                                    inventory.setItem(i, new ItemStack(Material.AIR));
                                }
                            }
                        }

                        blocks.put(location, block.getType());
                        location.getBlock().setType(blockType);
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
                            Material material = blocks.get(blocklock);

                            if(material != null) {

                                blocklock.getBlock().setType(material);

                                Block block = blocklock.getBlock();
                                BlockState state = block.getState();

                                if(state instanceof Container) {

                                    Container container2 = (Container) block.getState();
                                    Inventory inventory2 = container2.getInventory();

                                    for(int i = 0; i < inventory2.getSize(); i++) {

                                        Itm item = items.get(blocklock.toString() + " " + i);

                                        if (item != null) {
                                            if (item.getItemMeta() != null) {
                                                ItemStack itemStack = new ItemStack(item.getMaterial());
                                                itemStack.setItemMeta(item.getItemMeta());
                                                itemStack.setAmount(item.getCount());


                                                inventory2.setItem(item.getIndex(), itemStack);

                                                items.remove(blocklock.toString() + " " + i);

                                            }
                                        }
                                    }
                                }
                            }

                            blocks.remove(blocklock);

                            z = z + 1;
                        }
                        x = x + 1;
                        z = ZWAY;
                    }
                    y = y + 1;
                    x = XWAY;
                }
                cuboids.remove(cuboid);
            }

        }, 60);
    }

    public static void SetTrapka(Player player) {
        Location center = player.getLocation();
        World world = player.getWorld();

        int XWAY = (int) center.getX();
        int YWAY = (int) center.getY();
        int ZWAY = (int) center.getZ();

        int x = XWAY - 2;
        int y = YWAY - 1;
        int z = ZWAY - 2;

        Cuboid cuboid = new Cuboid(new Location(world, XWAY - 2, YWAY - 1, ZWAY - 2), new Location(world, XWAY+4, YWAY+4, ZWAY+4));

        cuboids.add(cuboid);

        for (int a = 1; a <= 5; a++) {      //Создание трапки и запись в кеш удаленных блоков
            for (int b = 1; b <= 5; b++) {
                for (int c = 1; c <= 5; c++) {
                    Location location = new Location(world, x, y, z);
                    Block block = location.getBlock();
                    BlockState state = block.getState();


                    int rnum = (int) (Math.random() * 2);
                    Material blockType = null;
                    if(rnum == 1) {
                        blockType = Material.OBSIDIAN;
                    } else {
                        blockType = Material.CRYING_OBSIDIAN;
                    }


                    if(block.getType() != Material.OBSIDIAN & block.getType() != Material.CRYING_OBSIDIAN & block.getType() != Material.BLACKSTONE_SLAB) {
                        if (state instanceof Container) {
                            Container container = (Container) state;
                            Inventory inventory = container.getInventory();

                            for (int i = 0; i < inventory.getSize(); i++) {
                                ItemStack item = inventory.getContents()[i];

                                if (item != null) {
                                    Itm itm = new Itm(item.getItemMeta(), item.getType(), item.getAmount(), i);
                                    items.put(location.toString() + " " + i, itm);
                                    inventory.setItem(i, new ItemStack(Material.AIR));
                                }
                            }
                        }

                        blocks.put(location, block.getType());
                        location.getBlock().setType(blockType);
                    }
                    z = z + 1;
                }
                x = x + 1;
                z = ZWAY - 2;
            }
            y = y + 1;
            x = XWAY - 2;
        }

        setTrapkaDecoration(center, player);

        player.getServer().getScheduler().scheduleSyncDelayedTask(Trapka.getInstance(), new Runnable() {   //Таймер по истечению которого удалится трапка и записи в кеше
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
                            Material material = blocks.get(blocklock);

                            if(material != null) {

                                blocklock.getBlock().setType(material);

                                Block block = blocklock.getBlock();
                                BlockState state = block.getState();

                                if(state instanceof Container) {

                                    Container container2 = (Container) block.getState();
                                    Inventory inventory2 = container2.getInventory();

                                    for(int i = 0; i < inventory2.getSize(); i++) {

                                        Itm item = items.get(blocklock.toString() + " " + i);

                                        if (item != null) {
                                            if (item.getItemMeta() != null) {
                                                ItemStack itemStack = new ItemStack(item.getMaterial());
                                                itemStack.setItemMeta(item.getItemMeta());
                                                itemStack.setAmount(item.getCount());


                                                inventory2.setItem(item.getIndex(), itemStack);

                                                items.remove(blocklock.toString() + " " + i);

                                            }
                                        }
                                    }
                                }
                            }
                            blocks.remove(blocklock);

                            z = z + 1;
                        }
                        x = x + 1;
                        z = ZWAY;
                    }
                    y = y + 1;
                    x = XWAY;
                }
                cuboids.remove(cuboid);
            }
        }, 200);

        }


}
