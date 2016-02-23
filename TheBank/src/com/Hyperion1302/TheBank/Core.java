package com.Hyperion1302.TheBank;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.Hyperion1302.TheBank.Commands.CommandHandler;
import com.Hyperion1302.TheBank.Commands.TheBankCommand;
import com.Hyperion1302.TheBank.Commands.TheBankSubCommands;

public class Core extends JavaPlugin {
	
	ConsoleCommandSender cmd = Bukkit.getConsoleSender();
	public PluginDescriptionFile pdf = this.getDescription();
	
	//File - Declaration
	public File playerBank;
	public FileConfiguration pbConfig;
	
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
		
		//Register
		cAPI.registerEvents();
		this.registerCommands();
		
		//File - Load
		playerBank = new File(this.getDataFolder() + "/PlayerBalance.yml");
		pbConfig = YamlConfiguration.loadConfiguration(playerBank);
		cAPI.loadCustomFile(playerBank, pbConfig);
	}
	
	public void onDisable() {
		
		//Log - Plugin Disabled
		cmd.sendMessage(cAPI.colourize("&c" + pdf.getName() + "v" + pdf.getVersion() + " has been disabled"));
		cmd.sendMessage(cAPI.colourize("Thanks for using " + pdf.getName()));
		
		//Save
		cAPI.saveCustomFile(playerBank, pbConfig);
	}
	

	public void registerCommands() {
		
		CommandHandler handler = new CommandHandler();
		
		handler.register("thebank", new TheBankCommand());
		handler.register("help", new TheBankSubCommands());
		handler.register("balance", new TheBankSubCommands());
		
		getCommand("thebank").setExecutor(handler);
	}

}
