package com.example.crystaloptimizer;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Config {
    private static final Gson GSON = new Gson();
    private static final String FILE_NAME = "crystaloptimizer.json";

    public int maxCrystalsRendered = 64;
    public double cullDistance = 64.0;
    public boolean disableBeam = true;

    private File getConfigFile() {
        return FabricLoader.getInstance().getConfigDir().resolve(FILE_NAME).toFile();
    }

    public void loadOrCreateDefaults() {
        File f = getConfigFile();
        try {
            if (f.exists()) {
                try (FileReader r = new FileReader(f)) {
                    Config other = GSON.fromJson(r, Config.class);
                    if (other != null) {
                        this.maxCrystalsRendered = other.maxCrystalsRendered;
                        this.cullDistance = other.cullDistance;
                        this.disableBeam = other.disableBeam;
                        return;
                    }
                }
            }
            try (FileWriter w = new FileWriter(f)) {
                w.write(GSON.toJson(this));
            }
        } catch (Exception e) {
            // keep defaults
        }
    }
}