package com.poompk.lobbypresentsrenewed.hooks.papi;

import com.poompk.lobbypresentsrenewed.LobbyPresentsRenewed;
import org.jetbrains.annotations.NotNull;

public class PlaceholderAPIHook {

    private final LobbyPresentsRenewed plugin;

    public PlaceholderAPIHook(@NotNull LobbyPresentsRenewed plugin) {
        this.plugin = plugin;
        if (isPapi()) {
            new LPRExpansion(plugin).register();
        }
    }

    public boolean isPapi() {
        return plugin.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI");
    }

}
