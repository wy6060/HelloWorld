package cn.mc597422.helloworld.GUI;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUI_JianCe implements Listener {
    @EventHandler
    public void check(InventoryClickEvent hw)
    {
        Player P = (Player) hw.getWhoClicked();
        if (hw.getWhoClicked().getOpenInventory().getTitle().equals(ChatColor.DARK_GREEN + "HelloWorld菜单"))
        {
            hw.setCancelled(true);
        }
        if (hw.getRawSlot()>hw.getInventory().getSize())
        {
            return;
        }
        if(hw.getRawSlot()<0)
        {
            return;
        }
        if(hw.getRawSlot()==11)
        {
            P.sendMessage(ChatColor.GREEN + "[HelloWorld] " + ChatColor.WHITE + "作者: MC597422");
        }
        else if (hw.getRawSlot()==13)
        {
            P.sendMessage(ChatColor.GREEN + "[HelloWorld] " + ChatColor.WHITE + "插件版本: 1.0");
        }
        else if (hw.getRawSlot()==15)
        {
            P.getPlayer().performCommand("helloworld 帮助");
        }
    }
}
