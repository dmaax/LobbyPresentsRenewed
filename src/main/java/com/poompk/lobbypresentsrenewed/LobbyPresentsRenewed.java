package com.poompk.lobbypresentsrenewed;

import com.poompk.lobbypresentsrenewed.versions.*;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyPresentsRenewed extends JavaPlugin {

    private Presents presents;
    public Integer SERVER_VERSION;

    @Override
    public void onEnable() {
        if (!validVersion()) disablePlugin("You server is running a version that is not supported.");
        registerEvents();
        registerCommands();
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll();
    }

    private boolean validVersion() {
        String version;
        try {
            version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        } catch (ArrayIndexOutOfBoundsException exception) {
            return false;
        }
        switch (version) {
            case "v1_8_R1":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_8_R1();
                SERVER_VERSION = 8;
                break;
            case "v1_8_R2":
                getLogger().info("Found NMS version: " + version + " This version is supported :)");
                presents = new v1_8_R2();
                SERVER_VERSION = 8;
                break;
            case "v1_8_R3":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_8_R3();
                SERVER_VERSION = 8;
                break;
            case "v1_9_R1":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_9_R1();
                SERVER_VERSION = 9;
                break;
            case "v1_9_R2":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_9_R2();
                SERVER_VERSION = 9;
                break;
            case "v1_10_R1":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_10_R1();
                SERVER_VERSION = 10;
                break;
            case "v1_11_R1":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_11_R1();
                SERVER_VERSION = 11;
                break;
            case "v1_12_R1":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_12_R1();
                SERVER_VERSION = 12;
                break;
            case "v1_13_R1":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_13_R1();
                SERVER_VERSION = 13;
                break;
            case "v1_13_R2":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_13_R2();
                SERVER_VERSION = 13;
                break;
            case "v1_14_R1":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_14_R1();
                SERVER_VERSION = 14;
                break;
            case "v1_15_R1":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_15_R1();
                SERVER_VERSION = 15;
                break;
            case "v1_16_R1":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_16_R1();
                SERVER_VERSION = 16;
                break;
            case "v1_16_R2":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_16_R2();
                SERVER_VERSION = 16;
                break;
            case "v1_16_R3":
                getLogger().info("Found NMS version: " + version);
                presents = new v1_16_R3();
                SERVER_VERSION = 16;
                break;
            default:
                break;
        }
        return presents != null;
    }

    private void disablePlugin(String message) {
        getLogger().severe(message);
        Bukkit.getServer().getPluginManager().disablePlugin(this);
    }

    private void registerEvents() {
    }

    private void registerCommands() {

    }

}
