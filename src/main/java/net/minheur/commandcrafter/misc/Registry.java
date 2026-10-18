package net.minheur.commandcrafter.misc;

import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minheur.commandcrafter.recipes.Recipe;
import org.jspecify.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public final class Registry {
    private static final Map<String, BiFunction<Recipe.ResultContainer, ServerPlayerEntity, ItemStack>> executorsHandler = new HashMap<>();

    public static void registerExecutor(String modId, BiFunction<Recipe.ResultContainer, ServerPlayerEntity, ItemStack> func) {
        if (executorsHandler.containsKey(modId)) return;
        executorsHandler.put(modId, func);
    }

    public static @Nullable ItemStack makeExecutor(Recipe.ResultContainer recipe, ServerPlayerEntity crafter) {
        for (BiFunction<Recipe.ResultContainer, ServerPlayerEntity, ItemStack> entry : executorsHandler.values()) {
            ItemStack returnValue = entry.apply(recipe, crafter);
            if (returnValue != null) return returnValue;
        }
        return null;
    }
}
