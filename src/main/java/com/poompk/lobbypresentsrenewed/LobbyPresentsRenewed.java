package com.poompk.lobbypresentsrenewed;

import com.poompk.lobbypresentsrenewed.managers.ConfigManager;
import com.poompk.lobbypresentsrenewed.managers.LanguageManager;
import com.poompk.lobbypresentsrenewed.versions.*;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyPresentsRenewed extends JavaPlugin {

    private static LobbyPresentsRenewed instance;
    private ConfigManager configManager;
    private LanguageManager languageManager;
    private Presents presents;
    public Integer SERVER_VERSION;

    @Override
    public void onEnable() {
        setupConfig();
        if (!validVersion()) {
            Bukkit.getLogger().severe("The server version you are running is UNSUPPORTED.");
        }
        instance = this;
        configManager = new ConfigManager();
        languageManager = new LanguageManager();

        configManager.load();
        languageManager.setup();
        registerEvents();
        registerCommands();
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll();
    }

    public static LobbyPresentsRenewed getInstance() {
        return instance;
    }

    private boolean validVersion() {
        String version;
        try {
            version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
            presents = SupportedVersions.getVersion(version);
            if (presents != null) {
                getLogger().info("Found NMS version: " + version);
                SERVER_VERSION = presents.getServerVersion();
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            return false;
        }
        return presents != null;
    }

    private void registerEvents() {
    }

    private void registerCommands() {

    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public LanguageManager getLanguageManager() {
        return languageManager;
    }

    private void setupConfig() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
