package cn.mc597422.helloworld;

import cn.mc597422.helloworld.GUI.GUI_JianCe;
import cn.mc597422.helloworld.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public void onEnable()
    {
        System.out.println(ChatColor.GREEN + "[HelloWorld] " + ChatColor.WHITE + "正在加载HelloWorld");
        System.out.println(ChatColor.GREEN + "[HelloWorld] " + ChatColor.WHITE + "你好，我的世界！");
        System.out.println(ChatColor.GREEN + "[HelloWorld] " + ChatColor.WHITE + "hello,minecraft!");
        System.out.println(ChatColor.GREEN + "[HelloWorld] " + ChatColor.WHITE + "然后？没了awa");
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_JianCe(),this);
        Bukkit.getPluginCommand("HelloWorld").setExecutor(new Command());
        Bukkit.getPluginCommand("HelloWorld").setTabCompleter(new Command());
        saveDefaultConfig();
    }
    public void onDisable()
    {
        System.out.println(ChatColor.GREEN + "[HelloWorld] " + ChatColor.WHITE + "插件卸载成功！");
    }
}
