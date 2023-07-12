package com.poompk.lobbypresentsrenewed.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.poompk.lobbypresentsrenewed.LobbyPresentsRenewed;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class ItemCreator {

    private static String skullMaterial() {
        LobbyPresentsRenewed plugin = LobbyPresentsRenewed.getInstance();
        return (plugin.SERVER_VERSION < 13) ? "SKULL_ITEM" : "LEGACY_SKULL_ITEM";
    }

    public static ItemStack createSkull(String url, String name) {
        ItemStack skullStack = new ItemStack(Material.matchMaterial(skullMaterial()), 1, (short) 3);
        if (url.isEmpty()) return skullStack;

        SkullMeta skullMeta = (SkullMeta) skullStack.getItemMeta();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), null);
        gameProfile.getProperties().put("textures", new Property("textures", url));

        try {
            Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, gameProfile);
        }
        catch (IllegalArgumentException | NoSuchFieldException | SecurityException | IllegalAccessException exception) {
            exception.printStackTrace();
        }

        skullStack.setItemMeta(skullMeta);
        return skullStack;
    }

}
