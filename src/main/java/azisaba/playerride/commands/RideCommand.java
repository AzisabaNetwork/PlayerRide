package azisaba.playerride.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class RideCommand implements CommandExecutor {
    public RideCommand() {
    }
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String lavel, @NotNull String[] args) {
        if (args.length < 1) {
            sender.sendMessage("§bUsage: /ride <target>");
            return false;
        }
        Player ridePlayer = (Player) sender;
        Player targetPlayer = Bukkit.getPlayerExact(args[0]);
        if (targetPlayer == null) return false;
        if (ridePlayer.getWorld() != targetPlayer.getWorld()) return false;
        if (ridePlayer.canSee(targetPlayer) && targetPlayer.canSee(ridePlayer) && ridePlayer.getLocation().distance(targetPlayer.getLocation()) <= 3) {
            targetPlayer.addPassenger(ridePlayer);

        }
        return true;
    }
}
