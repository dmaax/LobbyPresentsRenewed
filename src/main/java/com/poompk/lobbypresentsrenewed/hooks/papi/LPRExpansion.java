package com.poompk.lobbypresentsrenewed.hooks.papi;

import com.poompk.lobbypresentsrenewed.LobbyPresentsRenewed;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

public class LPRExpansion extends PlaceholderExpansion {

    private final LobbyPresentsRenewed plugin;

    public LPRExpansion(LobbyPresentsRenewed plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return plugin.getName().toLowerCase();
    }

    @Override
    public @NotNull String getAuthor() {
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (params.equals("presents_total")) {
            return "1";
        } else if (params.equals("presents_found")) {
            return "0";
        } else if (params.equals("presents_not_found")) {
            return "1";
        }
        return "";
    }

}
