package com.poompk.lobbypresentsrenewed;

import com.poompk.lobbypresentsrenewed.managers.ConfigManager;
import com.poompk.lobbypresentsrenewed.managers.LanguageManager;
import com.poompk.lobbypresentsrenewed.versions.*;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.MessageFormat;

public final class LobbyPresentsRenewed extends JavaPlugin {

    private static LobbyPresentsRenewed instance;
    private BukkitAudiences adventure;
    private ConfigManager configManager;
    private LanguageManager languageManager;
    private Presents presents;
    public Integer SERVER_VERSION;

    public @NotNull BukkitAudiences adventure() {
        if(this.adventure == null) {
            throw new IllegalStateException("Tried to access Adventure when the plugin was disabled!");
        }
        return this.adventure;
    }

    @Override
    public void onEnable() {
        setupConfig();
        if (!validVersion()) {
            Bukkit.getLogger().severe("The server version you are running is UNSUPPORTED.");
        }
        this.adventure = BukkitAudiences.create(this);
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
        if(this.adventure != null) {
            this.adventure.close();
            this.adventure = null;
        }
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

    public @NotNull String getLang(@NotNull String path, @Nullable FileConfiguration config, Object... args) {
        String language = null;
        if (config != null) {
            language = config.getString("language." + path);
        }
        if (language == null) {
            language = getLanguageManager().getConfig().getString(path,
                    getLanguageManager().getEnglishLanguageFile().getString(path, "<MISSING KEY: " + path + ">"));
        }
        return MessageFormat.format(language, args);
    }

    public String getLang(@NotNull String path, Object... args) {
        return getLang(path, (FileConfiguration) null, args);
    }

    private void setupConfig() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
