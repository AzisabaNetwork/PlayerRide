package azisaba.playerride;

import azisaba.playerride.commands.EjectCommand;
import azisaba.playerride.commands.RideCommand;
import azisaba.playerride.listener.PlayerEjectListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class PlayerRide extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new PlayerEjectListener(), this);
        Objects.requireNonNull(this.getCommand("ride")).setExecutor(new RideCommand());
        Objects.requireNonNull(this.getCommand("eject")).setExecutor(new EjectCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
