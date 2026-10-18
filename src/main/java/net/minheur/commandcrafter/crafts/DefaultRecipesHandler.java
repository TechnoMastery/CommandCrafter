package net.minheur.commandcrafter.crafts;

import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class DefaultRecipesHandler {
    private static final Path RECIPE_FOLDER = FabricLoader.getInstance().getConfigDir().resolve("betterosc/recipes");

    public static void checkAndCreate() {
        if (Files.exists(RECIPE_FOLDER)) return; // if recipe folder exists, pass

        try {
            Files.createDirectories(RECIPE_FOLDER); // ELSE MK FOLDER
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
