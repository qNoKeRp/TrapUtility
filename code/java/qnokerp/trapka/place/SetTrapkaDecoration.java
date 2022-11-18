package qnokerp.trapka.place;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Slab;
import org.bukkit.entity.Player;

public class SetTrapkaDecoration {
    public static void setTrapkaDecoration(Location center, Player player) {

        int XWAY = (int) center.getX();
        int YWAY = (int) center.getY();
        int ZWAY = (int) center.getZ();

        int x = XWAY - 1;
        int y = YWAY;
        int z = ZWAY - 1;

        //Дополнительные элементы трапки

        for (int a = 1; a <= 3; a++) {  //3х3 куб из воздуха
            for (int b = 1; b <= 3; b++) {
                for (int c = 1; c <= 3; c++) {
                    Location blocklock = new Location(player.getWorld(), x, y, z);

                    blocklock.getBlock().setType(Material.AIR);

                    z = z + 1;
                }
                x = x + 1;
                z = ZWAY - 1;
            }
            y = y + 1;
            x = XWAY - 1;
        }

        x = XWAY - 1;
        y = YWAY + 3;
        z = ZWAY - 1;


        for (int a = 1; a <= 2; a++ ) {  //Дырки сверху
            for(int b = 1; b <=2; b++) {
                Location blocklock = new Location(player.getWorld(), x, y, z);

                blocklock.getBlock().setType(Material.AIR);
                z = z + 2;
            }
            x = x + 2;
            z = ZWAY - 1;
        }

        x = XWAY - 2;
        y = YWAY;
        z = ZWAY - 1;
        for (int a = 1; a <= 2; a++ ) {  //Полублоки по бокам
            for(int b = 1; b <=2; b++) {
                Location blocklock = new Location(player.getWorld(), x, y, z);

                blocklock.getBlock().setType(Material.BLACKSTONE_SLAB);

                Block block = blocklock.getBlock();
                BlockData data = block.getBlockData();
                if (data instanceof Slab) {
                    Slab slab = (Slab) data;
                    slab.setType(Slab.Type.TOP);
                    block.setBlockData(slab);
                }
                x = x + 4;
            }
            z = z + 2;
            x = XWAY - 2;
        }


        x = XWAY - 1;
        y = YWAY;
        z = ZWAY - 2;

        for (int a = 1; a <= 2; a++ ) {  //Полублоки по бокам
            for(int b = 1; b <=2; b++) {
                Location blocklock = new Location(player.getWorld(), x, y, z);

                blocklock.getBlock().setType(Material.BLACKSTONE_SLAB);

                Block block = blocklock.getBlock();
                BlockData data = block.getBlockData();
                if (data instanceof Slab) {
                    Slab slab = (Slab) data;
                    slab.setType(Slab.Type.TOP);
                    block.setBlockData(slab);
                }
                z = z + 4;
            }
            x = x + 2;
            z = ZWAY - 2;
        }
    }
}
