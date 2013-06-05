package me.pluto1099.techmastary.arcadetp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class ArcadeTP extends JavaPlugin implements Listener {
	public static IconMenu im;

	public void onDisable() {
	}

	public void onEnable() {
		getServer().getPluginManager().registerEvents(im, this);
	}


    public boolean onCommand(CommandSender cs, Command c, String l, String [] args) {
        if (l.equalsIgnoreCase("hub")) {
            Player player = (Player) cs;
            IconMenu menu = new IconMenu("Minecraft Arcade Server Hub", 9, new IconMenu.OptionClickEventHandler() {
            private Plugin plugin;

			@Override
            public void onOptionClick(IconMenu.OptionClickEvent event) {
            	//if player has permission
            	 if (event.getPosition() == 3) {
            		 event.getPlayer().sendMessage("You have chosen " + event.getName());
            		 ByteArrayOutputStream b = new ByteArrayOutputStream();
            		 DataOutputStream out = new DataOutputStream(b);
            		  
            		 try {
            		     out.writeUTF("Connect");
            		     out.writeUTF("HungerGames"); // Target Server
            		 } catch (IOException e) {
            		     // Can never happen
            		 }
            		 event.getPlayer().sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
            	 }
            	 if (event.getPosition() == 4) {
                     event.getPlayer().sendMessage("You have chosen " + event.getName());
                     ByteArrayOutputStream b = new ByteArrayOutputStream();
                     DataOutputStream out = new DataOutputStream(b);
                      
                     try {
                         out.writeUTF("Connect");
                         out.writeUTF("Kits"); // Target Server
                     } catch (IOException e) {
                         // Can never happen
                     }
                     event.getPlayer().sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
             	 }
            	 if (event.getPosition() == 5) {
                     event.getPlayer().sendMessage("You have chosen " + event.getName());
                     ByteArrayOutputStream b = new ByteArrayOutputStream();
                     DataOutputStream out = new DataOutputStream(b);
                      
                     try {
                         out.writeUTF("Connect");
                         out.writeUTF("Skyblock"); // Target Server
                     } catch (IOException e) {
                         // Can never happen
                     }
                     event.getPlayer().sendPluginMessage(this.plugin, "BungeeCord", b.toByteArray());
             	 }
                    event.setWillClose(true);
            }
        	}, this)
            .setOption(3, new ItemStack(Material.ROTTEN_FLESH, 1), ChatColor.GREEN + "Survival Games", ChatColor.YELLOW + "May the odds be ever in your favor.")
            .setOption(4, new ItemStack(Material.GRASS, 1), ChatColor.BLUE + "Skyblock", ChatColor.YELLOW + "10k Skyblocks.")
            .setOption(5, new ItemStack(Material.DIAMOND_AXE, 1), ChatColor.AQUA + "Kits", ChatColor.YELLOW + "Ultimate KitPVP experience")
            .setOption(6, new ItemStack(Material.REDSTONE_BLOCK, 1), ChatColor.RED + "Coming Soon", ChatColor.YELLOW + "More gamemodes soon!");
            menu.open(player);
		}
        return false;
    }
}