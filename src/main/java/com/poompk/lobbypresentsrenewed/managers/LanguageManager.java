package com.poompk.lobbypresentsrenewed.managers;

import com.poompk.lobbypresentsrenewed.LobbyPresentsRenewed;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class LanguageManager {

    private FileConfiguration configFile;
    private File file;
    private String fileName;
    private YamlConfiguration englishLanguageFile;

    public void setup() {
        LobbyPresentsRenewed plugin = LobbyPresentsRenewed.getInstance();
        ConfigManager cm = plugin.getConfigManager();

        fileName = "language-" + cm.getLanguage() + ".yml";
        file = new File(plugin.getDataFolder(), fileName);
        if (!file.exists()) {
            plugin.saveResource(fileName, false);
        }
        configFile = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getConfig() {
        return configFile;
    }

    public FileConfiguration getEnglishLanguageFile() {
        if (englishLanguageFile == null) {
            InputStreamReader reader = new InputStreamReader(LobbyPresentsRenewed.getInstance().getResource("language-en.yml"));
            englishLanguageFile = YamlConfiguration.loadConfiguration(reader);
        }
        return englishLanguageFile;
    }

    public void save() {
        try {
            configFile.save(file);
        } catch (IOException e) {
            Bukkit.getServer().getLogger().log(Level.SEVERE, "{0}[LPR] Could not save {1}!",
                    new Object[]{ChatColor.RED, fileName});
        }
    }

    public void reload() {
        configFile = YamlConfiguration.loadConfiguration(file);
    }

}
