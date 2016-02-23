package com.Hyperion1302.TheBank.Commands;

import java.io.File;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.Hyperion1302.TheBank.Core;

public class TheBankSubCommands implements CommandInterface {
	
	Core cCore = Core.getInstance();

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		String pUUID = player.getUniqueId().toString();
		
		File playerBank = cCore.playerBank;
		FileConfiguration pbConfig = YamlConfiguration.loadConfiguration(playerBank);
		
		//Values - Configuration File
		int playerBalance = pbConfig.getInt("Player Balances." + pUUID + ".Balance");
		
		if (args[0].equalsIgnoreCase("help")) {
			player.sendMessage("Help Menu in progress.");
		}
		
		if (args[0].equalsIgnoreCase("balance")) {
			player.sendMessage("Bank Balance: " + playerBalance);
		}
		return false;
	}

}
