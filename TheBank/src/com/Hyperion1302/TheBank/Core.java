package com.Hyperion1302.TheBank;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	
	ConsoleCommandSender cmd = Bukkit.getConsoleSender();
	public PluginDescriptionFile pdf = this.getDescription();
	
	//File - Declaration
	File playerBank;
	FileConfiguration pbConfig;
	
	//Instances of classes
	API cAPI = API.getInstance();
	private static Core instance;
	public static Core getInstance() {
		return instance;
	}
	
	public void onEnable() {
		
		instance = this;
		
		//Log - Plugin Enabled
		cmd.sendMessage(cAPI.colourize("&2" + pdf.getName() + " has been enabled"));
		cmd.sendMessage(cAPI.colourize("&bVersion: " + pdf.getVersion()));
		cmd.sendMessage(cAPI.colourize("&bDeveloper: " + pdf.getAuthors()));
		cmd.sendMessage(cAPI.colourize("&bIf you like this plugin, be sure to go to the Spigot page to review this plugin."));
		
		//Events - Register
		cAPI.registerEvents();
		
		//File - Load
		playerBank = new File(this.getDataFolder() + "/PlayerBalance.yml");
		pbConfig = YamlConfiguration.loadConfiguration(playerBank);
	}
	
	public void onDisable() {
		
		//Log - Plugin Disabled
		cmd.sendMessage(cAPI.colourize("&c" + pdf.getName() + "v" + pdf.getVersion() + " has been disabled"));
		cmd.sendMessage(cAPI.colourize("Thanks for using " + pdf.getName()));
		
		//Save
		cAPI.saveCustomFile(playerBank, pbConfig);
	}

}
