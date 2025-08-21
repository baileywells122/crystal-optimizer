package com.example.crystaloptimizer.mixin;

import com.example.crystaloptimizer.CrystalOptimizerClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EndCrystalEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EndCrystalEntityRenderer.class)
public abstract class EndCrystalRendererMixin extends EntityRenderer<EndCrystalEntity> {
    protected EndCrystalRendererMixin() { super(null); }

    @Inject(method = "render(Lnet/minecraft/entity/decoration/EndCrystalEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",
            at = @At("HEAD"), cancellable = true)
    private void crystaloptimizer$limit(EndCrystalEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider consumers, int light, CallbackInfo ci) {
        Vec3d cam = MinecraftClient.getInstance().gameRenderer.getCamera().getPos();
        double distSq = cam.squaredDistanceTo(entity.getX(), entity.getY(), entity.getZ());
        double max = CrystalOptimizerClient.CONFIG.cullDistance;
        if (distSq > max * max) {
            ci.cancel();
            return;
        }
        if (CrystalOptimizerClient.crystalsRenderedThisFrame >= CrystalOptimizerClient.CONFIG.maxCrystalsRendered) {
            ci.cancel();
            return;
        }
        CrystalOptimizerClient.crystalsRenderedThisFrame++;
    }
}