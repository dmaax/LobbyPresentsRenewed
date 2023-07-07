package com.poompk.lobbypresentsrenewed.utils;

import com.mojang.authlib.GameProfile;
import com.poompk.lobbypresentsrenewed.LobbyPresentsRenewed;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class ItemCreator {

    private final LobbyPresentsRenewed instance;
    private static String SKULL_MATERIAL;

    public ItemCreator(LobbyPresentsRenewed instance) {
        this.instance = instance;
        if (instance.SERVER_VERSION < 13) {
            SKULL_MATERIAL = "SKULL_ITEM";
        } else {
            SKULL_MATERIAL= "LEGACY_SKULL_ITEM";
        }
    }

    public static ItemStack createSkull(String url, String name) {
        ItemStack skullStack = new ItemStack(Material.matchMaterial(SKULL_MATERIAL), 1, (short) 3);
        if (url.isEmpty()) return skullStack;

        SkullMeta skullMeta = (SkullMeta) skullStack.getItemMeta();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), null);
        ItemMeta itemMeta = skullStack.getItemMeta();
        return skullStack;
    }

}
