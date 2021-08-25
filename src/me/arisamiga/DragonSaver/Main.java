package me.arisamiga.DragonSaver;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new MyListener(), this);
		System.out.println("Successfully loaded DragonSaver!!");
	}

	@Override
	public void onDisable() {
		System.out.println("Successfully shutdown Dragonsaver!!");
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// help command
		if (label.equals("dragonsaver")) {
			if (sender instanceof Player) {
				// player
				Player player = (Player) sender;
				player.sendMessage(
						"DragonSaver: " + ChatColor.GREEN + "" + "Active | DragonSaver is currently running.");
				return true;
			} else {
				// console
				sender.sendMessage(
						"DragonSaver: " + ChatColor.GREEN + "" + "Active | DragonSaver is currently running.");
				return true;
			}

		}
		return false;

	}
}