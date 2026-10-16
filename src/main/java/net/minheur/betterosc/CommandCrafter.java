package net.minheur.betterosc;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minheur.betterosc.crafts.DefaultRecipesHandler;
import net.minheur.betterosc.crafts.RecipeCommandMaker;
import net.minheur.betterosc.recipes.RecipesHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicBoolean;

public final class CommandCrafter implements ModInitializer {

    public static final String MODID = "commandcrafter";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    public static final AtomicBoolean isTankModPresent = new AtomicBoolean(false);

    @Override
    public void onInitialize() {
        DefaultRecipesHandler.checkAndCreate();
        RecipesHandler.loadRecipes();
        RecipeCommandMaker.register();

        if (FabricLoader.getInstance().isModLoaded("itemtanks")) isTankModPresent.set(true);
    }
}
