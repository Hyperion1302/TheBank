package com.Hyperion1302.TheBank;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	
	Logger logger = Logger.getLogger("Minecraft");
	PluginDescriptionFile pdf = this.getDescription();
	
	API api = API.getInstance();
	
	public void onEnable() {
		
		//Log - Plugin Enabled
		logger.info(api.colourize("&2" + pdf.getName() + " has been enabled"));
		logger.info(api.colourize("&bVersion: " + pdf.getVersion()));
		logger.info(api.colourize("&bDeveloper: " + pdf.getAuthors()));
		logger.info(api.colourize("&bIf you like this plugin, be sure to go to the Spigot page to review this plugin."));
	}
	
	public void onDisable() {
		
		//Log - Plugin Disabled
		logger.info(api.colourize("&c" + pdf.getName() + "v" + pdf.getVersion() + " has been disabled"));
		logger.info(api.colourize("Thanks for using " + pdf.getName()));
	}

}
