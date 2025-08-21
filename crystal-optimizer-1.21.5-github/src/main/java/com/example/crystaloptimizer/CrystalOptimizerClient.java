package com.example.crystaloptimizer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class CrystalOptimizerClient implements ClientModInitializer {
    public static final Config CONFIG = new Config();
    public static int crystalsRenderedThisFrame = 0;

    @Override
    public void onInitializeClient() {
        CONFIG.loadOrCreateDefaults();
        ClientTickEvents.END_CLIENT_TICK.register(client -> crystalsRenderedThisFrame = 0);
    }
}