package com.poompk.lobbypresentsrenewed.versions;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public interface Presents {
    public void sendBlockChange(Player player, Location location);
    public void sendClickPresentParticle(Player player);
    public void sendHitEffectParticle(Player player, Block block, String effect);
    public void sendFoundPresentParticle(Player player, Block block, String effect);

    public void sendFoundSound(Player player, float level);
    public void sendPickupSound(Player player);
    public void sendTitleBar(Player player, String message);
    public void setupDefaultSound();
}
