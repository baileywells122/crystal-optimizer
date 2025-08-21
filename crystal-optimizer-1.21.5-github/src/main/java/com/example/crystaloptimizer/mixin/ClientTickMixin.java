package com.example.crystaloptimizer.mixin;

import com.example.crystaloptimizer.CrystalOptimizerClient;
import net.minecraft.entity.decoration.EndCrystalEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.client.render.entity.EndCrystalEntityRenderer")
public abstract class ClientTickMixin {
    @Redirect(method = "render(Lnet/minecraft/entity/decoration/EndCrystalEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/decoration/EndCrystalEntity;getBeamTarget()Lnet/minecraft/util/math/BlockPos;"))
    private Object crystaloptimizer$maybeDisableBeam(EndCrystalEntity instance) {
        if (CrystalOptimizerClient.CONFIG.disableBeam) {
            return null;
        }
        return instance.getBeamTarget();
    }
}