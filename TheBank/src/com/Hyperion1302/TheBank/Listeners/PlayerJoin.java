package com.Hyperion1302.TheBank.Listeners;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.Hyperion1302.TheBank.API;
import com.Hyperion1302.TheBank.Core;

public class PlayerJoin implements Listener {
	
	API cAPI = API.getInstance();
	Core cCore = Core.getInstance();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		Player player = event.getPlayer();
		String pUUID = player.getUniqueId().toString();
		
		File playerBank = cCore.playerBank;
		FileConfiguration pbConfig = YamlConfiguration.loadConfiguration(playerBank);
		
		//Values - Configuration File
		int playerBalance = pbConfig.getInt("Player Balances." + pUUID + ".Balance");
		
		//Alert - If server is using plugin (OP only)
		if (player.isOp()) {
			player.sendMessage(cAPI.colourize("&c&lAlert> This server is using " + cCore.pdf.getName()));
		}
		
		//Check - Player Balance (existence)
		if (!pbConfig.contains("Player Balances." + pUUID + ".Balance")) {
			pbConfig.set("Player Balances." + pUUID + ".Balance", 0);
			player.sendMessage("Your [Bank Account] has been created!");
			player.sendMessage("You have a balance of " + playerBalance);
			cAPI.saveCustomFile(playerBank, pbConfig);
		} else {
			player.sendMessage("Bank Balance: " + playerBalance);
		}
		
	}

}
