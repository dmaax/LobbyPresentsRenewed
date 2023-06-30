package com.poompk.lobbypresentsrenewed.managers;

import com.poompk.lobbypresentsrenewed.LobbyPresentsRenewed;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class ConfigManager {

    private final LobbyPresentsRenewed plugin = LobbyPresentsRenewed.getInstance();
    private FileConfiguration config;

    public void save() {
        plugin.saveConfig();
    }

    public void load() {
        plugin.reloadConfig();
        config = plugin.getConfig();
    }

    public boolean isDebug() {
        return config.getBoolean("debug");
    }

    public String getLanguage() {
        String language = config.getString("language");
        if (language == null || language.equalsIgnoreCase("")) {
            language = "en";
        }
        return language;
    }

    public boolean isSql() {
        return config.getBoolean("sql.enabled");
    }

    public String getSqlHostname() {
        return config.getString("sql.mysql.hostname");
    }

    public int getSqlPort() {
        return config.getInt("sql.mysql.port");
    }

    public String getSqlDatabase() {
        return config.getString("sql.database");
    }

    public String getSqlUsername() {
        return config.getString("sql.mysql.username");
    }

    public String getSqlPassword() {
        return config.getString("sql.mysql.password");
    }

    public int getEffectsDistance() {
        return config.getInt("effects.distance");
    }

    public int getEffectsTicks() {
        return config.getInt("effects.ticks");
    }

    public String getClickEffectType() {
        return config.getString("effects.click.type");
    }

    public String getCanClaimEffectType() {
        return config.getString("effects.can-claim.type");
    }

    public int getCanClaimEffectAmount() {
        return config.getInt("effects.can-claim.amount");
    }

    public String getClaimedEffectType() {
        return config.getString("effects.claimed.type");
    }

    public boolean isActionBar() {
        return config.getBoolean("action-bar.enabled");
    }

    public String actionBarWorldName() {
        return config.getString("action-bar.world");
    }

    public int getActionBarUpdate() {
        return config.getInt("action-bar.update");
    }

    public String getCanClaimSound() {
        return config.getString("sounds.can-claim");
    }

    public String getClaimedSound() {
        return config.getString("sounds.claimed");
    }

    public String getRewardsType() {
        return config.getString("rewards.type");
    }

    public List<String> getRewardsSequence() {
        return config.getStringList("reward.sequence-rewards");
    }

}
