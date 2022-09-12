package dev.schmarrn.letsjeb.mixin;

import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.util.DyeColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(SheepEntity.class)
public class SheepShearMixin {

    @Inject(at = @At("HEAD"), method = "getColor()Lnet/minecraft/util/DyeColor;", cancellable = true)
    private void letsjeb$getColor(final CallbackInfoReturnable<DyeColor> cir) {
        SheepEntity dolly = (SheepEntity) (Object) this;
        if (!dolly.world.isClient && dolly.hasCustomName() && dolly.getName().getString().equals("jeb_")) {
            int color = new Random().nextInt(16);
            cir.setReturnValue(DyeColor.byId(color));
        }
    }
}
