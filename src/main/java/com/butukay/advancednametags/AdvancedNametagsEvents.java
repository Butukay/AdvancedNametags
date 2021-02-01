package com.butukay.advancednametags;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class AdvancedNametagsEvents implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        AdvancedNametags.NoNameTagTeam.addPlayer(event.getPlayer());
    }

    @EventHandler
    public void onPlayerInteractEntity(final PlayerInteractAtEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player) {
            final Player player = (Player) e.getRightClicked();

            final String formatedNick = String.format(AdvancedNametags.getPlugin(AdvancedNametags.class).getConfig().getString("nickname-format"), player.getName());

            e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(formatedNick));
        }
    }
}
