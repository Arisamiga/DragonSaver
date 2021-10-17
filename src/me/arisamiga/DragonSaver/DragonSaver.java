package me.arisamiga.DragonSaver;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class DragonSaver extends JavaPlugin {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new DragonDamagedListener(), this);
		System.out.println("Successfully loaded DragonSaver!!");
	}

	@Override
	public void onDisable() {
		System.out.println("Successfully shutdown Dragonsaver!!");
	}

	public static String option = "No Option";
	public static boolean power = true;

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equals("dragonsaver")) {
			if (sender instanceof Player) {

				Player player = (Player) sender;
				if (!player.hasPermission("dragonsaver")) {
					player.sendMessage(
							ChatColor.GRAY + "" + "DragonSaver: " + ChatColor.RED + "" + "You cant use this command");
					return true;
				}
				if (args.length == 0) {
					if (power) {
						player.sendMessage(ChatColor.GRAY + "" + "DragonSaver: " + ChatColor.GREEN + ""
								+ "Active | DragonSaver is currently running.");
						return true;
					} else {
						player.sendMessage(ChatColor.GRAY + "" + "DragonSaver: " + ChatColor.RED + ""
								+ "Inactive | DragonSaver is currently not running.");
						return true;
					}
				}
				if (args[0].equalsIgnoreCase("on")) {
					player.sendMessage(ChatColor.GRAY + "" + "DragonSaver" + ChatColor.WHITE + "" + "  has been Turned"
							+ ChatColor.GREEN + "" + " on");
					power = true;
					return true;
				} else if (args[0].equalsIgnoreCase("off")) {
					player.sendMessage(ChatColor.GRAY + "" + "DragonSaver" + ChatColor.WHITE + "" + " has been Turned "
							+ ChatColor.RED + "" + " off");
					power = false;
					return true;
				}else {
					player.sendMessage(
							"Please pick one of the following arguments" + ChatColor.GRAY + "" + " (on,off)");
					return true;
				}
			} else {
				if (args.length == 0) {
					if (power) {
						sender.sendMessage(
								"DragonSaver: " + ChatColor.GREEN + "" + "Active | DragonSaver is currently running.");
						return true;
					} else {
						sender.sendMessage("DragonSaver: " + ChatColor.RED + ""
								+ "Inactive | DragonSaver is currently not running.");
						return true;
					}
				}
				if (args[0].equalsIgnoreCase("on")) {
					sender.sendMessage("DragonSaver has been Turned on!");
					power = true;
					return true;
				} else if (args[0].equalsIgnoreCase("off")) {
					sender.sendMessage("DragonSaver has been Turned off!");
					power = false;
					return true;
				}
			}

		}
		if (label.equals("dragonsaver-type")) {
			if (sender instanceof Player) {

				Player player = (Player) sender;
				if (!player.hasPermission("dragosaver-type")) {
					player.sendMessage(
							ChatColor.GRAY + "" + "DragonSaver: " + ChatColor.RED + "" + "You cant use this command");
					return true;
				}
				if (args.length == 0) {
					player.sendMessage(ChatColor.GRAY + "" + "Current Options: " + ChatColor.WHITE + "" + option);
					return true;
				}
				if (args[0].equalsIgnoreCase("kill")) {
					player.sendMessage(ChatColor.GRAY + "" + "DragonSaver" + ChatColor.WHITE + ""
							+ " will now kill the player when they hit the dragon.");
					option = "Kill";
					return true;
				} else if (args[0].equalsIgnoreCase("ban")) {
					player.sendMessage(ChatColor.GRAY + "" + "DragonSaver" + ChatColor.WHITE + ""
							+ " will now ban the player when they hit the dragon.");
					option = "Ban";
					return true;
				} else if (args[0].equalsIgnoreCase("kick")) {
					option = "Kick";
					player.sendMessage(ChatColor.GRAY + "" + "DragonSaver" + ChatColor.WHITE + ""
							+ " will now kick the player when they hit the dragon.");
					return true;
				} else {
					player.sendMessage(
							"Please pick one of the following arguments" + ChatColor.GRAY + "" + " (Kill, Ban, Kick)");
					return true;
				}
			} else {
				if (args.length == 0) {
					sender.sendMessage("Current Options: " + option);
					return true;
				}
				if (args[0].equalsIgnoreCase("kill")) {
					sender.sendMessage("DragonSaver will now kill the player when they hit the dragon.");
					option = "Kill";
					return true;
				} else if (args[0].equalsIgnoreCase("ban")) {
					sender.sendMessage("DragonSaver will now ban the player when they hit the dragon.");
					option = "Ban";
					return true;
				} else if (args[0].equalsIgnoreCase("kick")) {
					option = "Kick";
					sender.sendMessage("DragonSaver will now kick the player when they hit the dragon.");
					return true;
				} else {
					sender.sendMessage("Please pick one of the following arguments (Kill, Ban, Kick)");
					return true;
				}
			}
		}
		return false;
	}
}