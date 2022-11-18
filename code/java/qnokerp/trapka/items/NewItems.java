package qnokerp.trapka.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;


public class NewItems {
    public static ItemStack TrapkaItemStack() {    //инициализация трапки
        ItemStack itemStack = new ItemStack(Material.NETHERITE_SCRAP);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.RED + "Тряпка");

        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public static ItemStack PlastItemStack() {    //инициализация пласта

        ItemStack itemStack = new ItemStack(Material.DRIED_KELP);
        ItemMeta meta = itemStack.getItemMeta();

        meta.setDisplayName(ChatColor.RED + "Пластун");

        itemStack.setItemMeta(meta);

        return itemStack;
    }

}
