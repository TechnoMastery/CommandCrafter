package net.minheur.commandcrafter;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minheur.commandcrafter.crafts.DefaultRecipesHandler;
import net.minheur.commandcrafter.crafts.RecipeCommandMaker;
import net.minheur.commandcrafter.recipes.RecipesHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

public final class CommandCrafter implements ModInitializer {

    public static final String MODID = "craftbycommands";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public static final AtomicBoolean isTankModPresent = new AtomicBoolean(false);

    @Override
    public void onInitialize() {
        DefaultRecipesHandler.checkAndCreate();
        RecipeCommandMaker.register();
        ServerLifecycleEvents.SERVER_STARTED.register(event -> RecipesHandler.loadRecipes());

        if (FabricLoader.getInstance().isModLoaded("itemtanks")) isTankModPresent.set(true);
    }
}
