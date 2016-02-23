package com.Hyperion1302.TheBank.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TheBankCommand implements CommandInterface {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		player.sendMessage("For more information, do /thebank help");
		return false;
	}

}
