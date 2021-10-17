package me.arisamiga.DragonSaver;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World.Environment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class DragonDamagedListener implements Listener {

	@EventHandler
	public void crystalDamage(EntityDamageEvent event) {
		Boolean power = DragonSaver.power;
		Entity entity = event.getEntity();
		if (entity.getType() == EntityType.ENDER_CRYSTAL
				&& event.getEntity().getWorld().getEnvironment() == Environment.THE_END && power == true) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void cancelBed(PlayerBedEnterEvent event) {
		Boolean power = DragonSaver.power;
		if (event.getPlayer().getWorld().getEnvironment() == Environment.THE_END && power == true) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onMobHit(EntityDamageByEntityEvent event) throws InterruptedException {
		Boolean power = DragonSaver.power;
		String options = DragonSaver.option;
		Entity e = event.getDamager();
		if (event.getEntityType().equals(EntityType.ENDER_DRAGON) && power == true) {
			event.setCancelled(true);
			System.out.println(e.getType().toString());
			System.out.println(options);
			if (e.getType().toString().equals("PLAYER")) {
				if (options.equals("Kill")) {
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "kill " + e.getName());
					Bukkit.getServer()
							.broadcastMessage(e.getName() + " Was killed because he tried to damage the Ender Dragon");
				}
				if (options.equals("Kick")) {
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "kick " + e.getName()
							+ " " + ChatColor.RED + "" + " We dont allow people who damage the Ender Dragon.");
					Bukkit.getServer()
							.broadcastMessage(e.getName() + " Was kicked because he tried to damage the Ender Dragon");
				}
				if (options.equals("Ban")) {
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ban " + e.getName() + " "
							+ ChatColor.RED + "" + " We dont allow people who damage the Ender Dragon.");
					Bukkit.getServer()
							.broadcastMessage(e.getName() + " Was banned because he tried to damage the Ender Dragon");
				}
			}

		}
	}
}
