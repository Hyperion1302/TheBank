package com.Hyperion1302.TheBank;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	
	Logger logger = Logger.getLogger("Minecraft");
	PluginDescriptionFile pdf = this.getDescription();
	
	public void onEnable() {
		
		//Log - Plugin Enabled
		logger.info("TheBank v1 enabled");
	}
	
	public void onDisable() {
		
		//Log - Plugin Disabled
		logger.info("TheBank v1 disabled");
	}

}
