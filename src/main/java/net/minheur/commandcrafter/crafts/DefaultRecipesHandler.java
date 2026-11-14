package net.minheur.commandcrafter.crafts;

import net.minheur.commandcrafter.CommandCrafter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class DefaultRecipesHandler {
    public static final Path RECIPE_FOLDER = CommandCrafter.RECIPE_FOLDER;

    public static void checkAndCreate() {
        if (Files.exists(RECIPE_FOLDER)) return; // if recipe folder exists, pass

        try {
            Files.createDirectories(RECIPE_FOLDER); // ELSE MK FOLDER
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
