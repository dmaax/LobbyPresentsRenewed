package com.poompk.lobbypresentsrenewed.versions;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class v1_8_R2 implements Presents {
    @Override
    public void sendBlockChange(Player player, Location location) {

    }

    @Override
    public void sendClickPresentParticle(Player player) {

    }

    @Override
    public void sendHitEffectParticle(Player player, Block block, String effect) {
    }

    @Override
    public void sendFoundPresentParticle(Player player, Block block, String effect) {

    }

    @Override
    public void sendFoundSound(Player player, float level) {

    }

    @Override
    public void sendPickupSound(Player player) {

    }

    @Override
    public void sendTitleBar(Player player, String message) {

    }

    @Override
    public void setupDefaultSound() {

    }

    @Override
    public Integer getServerVersion() {
        return 8;
    };
}
