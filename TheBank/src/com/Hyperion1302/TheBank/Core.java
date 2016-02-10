package com.Hyperion1302.TheBank;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	
	ConsoleCommandSender cmd = Bukkit.getConsoleSender();
	public PluginDescriptionFile pdf = this.getDescription();
	
	API api = API.getInstance();
	private static Core instance;
	public static Core getInstance() {
		return instance;
	}
	
	public void onEnable() {
		
		instance = this;
		
		//Log - Plugin Enabled
		cmd.sendMessage(api.colourize("&2" + pdf.getName() + " has been enabled"));
		cmd.sendMessage(api.colourize("&bVersion: " + pdf.getVersion()));
		cmd.sendMessage(api.colourize("&bDeveloper: " + pdf.getAuthors()));
		cmd.sendMessage(api.colourize("&bIf you like this plugin, be sure to go to the Spigot page to review this plugin."));
		
		//Register Events
		api.registerEvents();
	}
	
	public void onDisable() {
		
		//Log - Plugin Disabled
		cmd.sendMessage(api.colourize("&c" + pdf.getName() + "v" + pdf.getVersion() + " has been disabled"));
		cmd.sendMessage(api.colourize("Thanks for using " + pdf.getName()));
	}

}
