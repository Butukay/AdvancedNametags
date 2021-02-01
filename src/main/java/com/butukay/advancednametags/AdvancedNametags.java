package com.butukay.advancednametags;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.NameTagVisibility;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.util.Set;

public final class AdvancedNametags extends JavaPlugin {

    public static Team NoNameTagTeam;

    public void onEnable() {

        if (!new File(this.getDataFolder(), "config.yml").exists()) {
            this.saveDefaultConfig();
        }

        this.getServer().getPluginManager().registerEvents(new AdvancedNametagsEvents(), this);

        ScoreboardManager sbm = this.getServer().getScoreboardManager();

        if (sbm.getMainScoreboard().getTeam("NoNameTagTeam") == null) {
            sbm.getMainScoreboard().registerNewTeam("NoNameTagTeam");
        }

        NoNameTagTeam = sbm.getMainScoreboard().getTeam("NoNameTagTeam");
        NoNameTagTeam.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);
    }


    @Override
    public void onDisable() {

    }
}
