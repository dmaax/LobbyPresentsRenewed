package com.poompk.lobbypresentsrenewed.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MiniMessageUtils {

    private static final Map<String, String> COLOR_MAP = new HashMap<>();

    static {
        COLOR_MAP.put("&1", "<dark_blue>");
        COLOR_MAP.put("&2", "<dark_green>");
        COLOR_MAP.put("&3", "<dark_aqua>");
        COLOR_MAP.put("&4", "<dark_red>");
        COLOR_MAP.put("&5", "<dark_purple>");
        COLOR_MAP.put("&6", "<gold>");
        COLOR_MAP.put("&7", "<gray>");
        COLOR_MAP.put("&8", "<dark_gray>");
        COLOR_MAP.put("&9", "<blue>");
        COLOR_MAP.put("&a", "<green>");
        COLOR_MAP.put("&b", "<aqua>");
        COLOR_MAP.put("&c", "<red>");
        COLOR_MAP.put("&d", "<light_purple>");
        COLOR_MAP.put("&e", "<yellow>");
        COLOR_MAP.put("&f", "<white>");
        COLOR_MAP.put("&l", "<bold>");
        COLOR_MAP.put("&k", "<obfuscated>");
        COLOR_MAP.put("&m", "<strikethrough>");
        COLOR_MAP.put("&n", "<underline>");
    }

    private static String replaceLegacyText(String legacyText) {
        StringBuilder result = new StringBuilder(legacyText);
        for (Map.Entry<String, String> entry : COLOR_MAP.entrySet()) {
            legacyText = legacyText.replaceAll(entry.getKey(), entry.getValue());
        }
        return legacyText;
    }

    public static Component getParsedMiniMessage(@NotNull String messageKey) {
        MiniMessage miniMessage = MiniMessage.miniMessage();
        return miniMessage.deserialize(Objects.requireNonNull(replaceLegacyText(messageKey)));
    }

}
