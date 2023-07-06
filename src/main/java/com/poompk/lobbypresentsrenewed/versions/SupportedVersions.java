package com.poompk.lobbypresentsrenewed.versions;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class SupportedVersions {

    private static final Map<String, Presents> versionMap = new HashMap<>();

    static {
        versionMap.put("v1_8_R1", new v1_8_R1());
        versionMap.put("v1_8_R2", new v1_8_R2());
        versionMap.put("v1_8_R3", new v1_8_R3());
        versionMap.put("v1_9_R1", new v1_9_R1());
        versionMap.put("v1_9_R2", new v1_9_R2());
        versionMap.put("v1_10_R1", new v1_10_R1());
        versionMap.put("v1_11_R1", new v1_11_R1());
        versionMap.put("v1_12_R1", new v1_12_R1());
        versionMap.put("v1_13_R1", new v1_13_R1());
        versionMap.put("v1_13_R2", new v1_13_R2());
        versionMap.put("v1_14_R1", new v1_14_R1());
        versionMap.put("v1_15_R1", new v1_15_R1());
        versionMap.put("v1_16_R1", new v1_16_R1());
        versionMap.put("v1_16_R2", new v1_16_R2());
        versionMap.put("v1_16_R3", new v1_16_R3());
    }

    public static Presents getVersion(String version) {
        Presents implementation = versionMap.get(version);
        if (implementation == null) {
            Plugin plugin = Bukkit.getPluginManager().getPlugin("LobbyPresentsRenewed");
            plugin.getPluginLoader().disablePlugin(plugin);
            throw new UnsupportedOperationException("Unsupported server version: " + version);
        }
        return implementation;
    }

}
