package me.arisamiga.DragonSaver;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class MyListener implements Listener {
	@EventHandler
	public void onMobHit(EntityDamageByEntityEvent event) throws InterruptedException {
		Entity e = event.getDamager();
		if (event.getEntityType() == EntityType.ENDER_DRAGON) {
			System.out.println(e.getType().toString() != "PLAYER");
			if (e.getType().toString() != "PLAYER") {
				if (event.getEntity() instanceof LivingEntity) {
					LivingEntity living = (LivingEntity) event.getEntity();
					living.setHealth(200);
				}
			} else {
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "kill " + e.getName());
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ban " + e.getName() + " "
						+ ChatColor.RED + "" + " We dont allow people who damage the Ender Dragon.");
				Bukkit.getServer()
						.broadcastMessage(e.getName() + " Was banned because he tried to damage the Ender Dragon");
			}

		}
	}
}
