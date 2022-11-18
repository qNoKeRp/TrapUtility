package qnokerp.trapka.utils;

import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

public class Itm {
    private ItemMeta itemMeta;

    private Material material;
    private Integer count;
    private Integer index;


    public Itm(final ItemMeta itemMeta, final Material material, final int count, final int index) {
        this.itemMeta = itemMeta;
        this.material = material;
        this.count = count;
        this.index = index;
    }

    public ItemMeta getItemMeta() {
        if (this.itemMeta != null)  return this.itemMeta;

        return null;
    }


    public Material getMaterial() {
        if (this.material != null)  return this.material;

        return null;
    }

    public Integer getIndex() {
        if (this.index != null)  return this.index;

        return null;
    }


    public Integer getCount() {
        if (this.count != null) return this.count;

        return null;
    }


}
