package net.minheur.commandcrafter.misc;

import net.minecraft.item.ItemStack;
import net.minheur.itemtanks.TankHandler;
import net.minheur.itemtanks.operations.TankOperationHandler;

/**
 * Implementation allowing to use ItemTanks to store recipe ingredients.<br>
 * <b>WARNING:</b> This class and it's methods should only be called if the presence of ItemTanks was previously checked and return true.
 * Doing otherwise may lead to an exception.
 */
public final class TankIntegration {

    public static boolean isTank(ItemStack candidate) {
        return TankHandler.isTank(candidate);
    }

    public static ItemStack getTankContent(ItemStack tank) {
        return TankOperationHandler.getTankContent(tank);
    }
    public static long getTankAmount(ItemStack tank) {
        return TankOperationHandler.getAmountStored(tank);
    }

    public static void decrement(ItemStack tank, long amount) {
        TankOperationHandler.decrementTank(tank, amount);
    }

}
