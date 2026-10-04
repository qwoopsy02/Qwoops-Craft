package mod.qwoopscraft.mixin;

import mod.qwoopscraft.item.ModItems;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class RiceBowlItemEntityMixin {
    @Inject(method = "tick", at = @At("TAIL"))
    private void qwoopscraft$cleanRiceInWater(CallbackInfo callbackInfo) {
        ItemEntity itemEntity = (ItemEntity) (Object) this;
        if (itemEntity.level().isClientSide() || !itemEntity.isInWater()) {
            return;
        }

        ItemStack droppedStack = itemEntity.getItem();
        if (droppedStack.is(ModItems.UNCLEAN_RICE_BOWL)) {
            itemEntity.setItem(new ItemStack(ModItems.CLEAN_RICE_BOWL, droppedStack.getCount()));
        }
    }
}
