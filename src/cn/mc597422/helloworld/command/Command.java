package cn.mc597422.helloworld.command;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Command implements CommandExecutor, TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String s, String[] args)
    {
        String K = " ";
        if (sender.hasPermission("helloworld.command"))
            if (args.length == 0)
            {
                sender.sendMessage(ChatColor.GREEN + "==============HelloWorld帮助==============");
                sender.sendMessage(ChatColor.WHITE + "/HelloWorld 只因 >> 查看只因");
                sender.sendMessage(ChatColor.WHITE + "/HelloWorld 帮助 >> 查看帮助");
                sender.sendMessage(ChatColor.WHITE + "/HelloWorld 菜单 >> 查看菜单");
                sender.sendMessage(ChatColor.WHITE + "/HelloWorld 我的名字 >> 查看自己的名字");
                sender.sendMessage(ChatColor.GREEN + "===============就这么多了awa===============");
            }
        else if (args.length == 1) {
            String arg_to_string = args[0];
            if (arg_to_string.equals("只因"))
                {
                    //发送的消息
                    sender.sendMessage(ChatColor.GREEN + "[HelloWorld]" + ChatColor.WHITE + "你干嘛哈哈~~哎哟");
                }
            else if (arg_to_string.equals("帮助"))
                {
                    //帮助消息
                    sender.sendMessage(ChatColor.GREEN + "==============HelloWorld帮助==============");
                    sender.sendMessage(ChatColor.WHITE + "/HelloWorld 只因 >> 查看只因");
                    sender.sendMessage(ChatColor.WHITE + "/HelloWorld 帮助 >> 查看帮助");
                    sender.sendMessage(ChatColor.WHITE + "/HelloWorld 菜单 >> 查看菜单");
                    sender.sendMessage(ChatColor.WHITE + "/HelloWorld 我的名字 >> 查看自己的名字");
                    sender.sendMessage(ChatColor.GREEN + "===============就这么多了awa===============");
                }
            else if (arg_to_string.equals("菜单")) {
                if (!(sender instanceof Player))
                {
                    sender.sendMessage(ChatColor.GREEN + "[HelloWorld]" + K + ChatColor.RED + "请以玩家身份执行这个指令！");
                    return false;
                }
                if (!sender.isOp()) ;
                //菜单设置
                //菜单大小，名称设置
                Inventory GUI = Bukkit.createInventory(null, 3 * 9, ChatColor.DARK_GREEN + "HelloWorld菜单");
                //草方块
                ItemStack GRASS = new ItemStack(Material.GRASS_BLOCK);
                ItemMeta G = GRASS.getItemMeta();
                //物品名称
                G.setDisplayName("§aHelloWorld帮助");
                GRASS.setItemMeta(G);
                //loer设置
                List<String> Glore = new ArrayList<>();
                Glore.add("左键点击查看帮助");
                GUI.setItem(15, GRASS);
                //橡木木板O
                ItemStack PLANKS = new ItemStack(Material.OAK_PLANKS);
                ItemMeta P = PLANKS.getItemMeta();
                //物品名称
                P.setDisplayName("§eHelloWorld版本");
                PLANKS.setItemMeta(P);
                //loer设置
                List<String> Plore = new ArrayList<>();
                Plore.add("左键点击查看版本");
                GUI.setItem(13, PLANKS);
                //石头
                ItemStack STONE = new ItemStack(Material.STONE);
                ItemMeta S = STONE.getItemMeta();
                //物品名称
                S.setDisplayName("§bHelloWorld作者");
                STONE.setItemMeta(S);
                //loer设置
                List<String> Slore = new ArrayList<>();
                Slore.add("左键点击查看作者");
                GUI.setItem(11, STONE);
                //设置玩家打开菜单
                Player p = (Player) sender;
                p.openInventory(GUI);
                //菜单发送消息
                sender.sendMessage(ChatColor.GREEN + "[HelloWorld]" + K + ChatColor.WHITE + "你打开了菜单");
            } else if (arg_to_string.equals("我的名字")) {
                if (!(sender instanceof Player))
                {
                    sender.sendMessage(ChatColor.GREEN + "[HelloWorld]" + K + ChatColor.RED + "请以玩家身份执行这个指令！");
                }
                Player player = (Player) sender;
                String message = "%player_name%";
                message = PlaceholderAPI.setPlaceholders(player, message);
                ((Player) sender).sendMessage(ChatColor.GREEN + "[HelloWorld]" + K + ChatColor.WHITE + "你的名字是: " + message);
            } else
            //输入错误时的消息
            {
                sender.sendMessage("§c输入错误");
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String s, String[] args) {
        if(args.length==1)
        {
            List<String> list = new ArrayList<>();
            //Tab自动补充指令列表
            list.add("帮助");
            list.add("只因");
            list.add("菜单");
            list.add("我的名字");
            return list;
        }
        return null;
    }
}
