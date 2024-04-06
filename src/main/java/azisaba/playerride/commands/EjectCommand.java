package azisaba.playerride.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EjectCommand implements CommandExecutor {
    public EjectCommand() {
    }
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String lavel, @NotNull String[] args) {
        Player player = (Player) sender;
        player.eject();
        return true;
    }
}
