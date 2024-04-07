package azisaba.playerride.listener;

import azisaba.playerride.PlayerRide;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.spigotmc.event.entity.EntityDismountEvent;

import static org.bukkit.Bukkit.getServer;

public class PlayerEjectListener implements Listener {
    @EventHandler
    public void onPlayerDismount(EntityDismountEvent e) {
        if (e.isCancelled()) return;
        if (e.getDismounted() instanceof Player && e.getEntity() instanceof Player) {
            Player mountedPlayer = (Player)e.getDismounted();
            Player exitPlayer = (Player)e.getEntity();

            BukkitScheduler scheduler = getServer().getScheduler();

            ejectAll(exitPlayer, mountedPlayer.getLocation());

            scheduler.runTaskLater(JavaPlugin.getPlugin(PlayerRide.class), () -> exitPlayer.teleport(mountedPlayer.getLocation()), 1);
        }
    }
    public static void ejectAll(Player player, Location location) {
        for (Entity e : player.getPassengers()) {
            if (e instanceof Player) {
                ejectAll((Player) e, location);
            }
        }
        player.eject();
        player.teleport(location);
    }
}
