package user11681.soulboundarmory.asm.mixin.entity.player;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import user11681.soulboundarmory.entity.SoulboundArmoryAttributes;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
    @Unique
    private final PlayerEntity self = (PlayerEntity) (Object) this;

    protected PlayerEntityMixin(final EntityType<? extends LivingEntity> entityType, final World world) {
        super(entityType, world);
    }

    @ModifyArg(method = "attack", index = 1, at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;damage(Lnet/minecraft/entity/damage/DamageSource;F)Z"))
    private float applyCriticalStrikeProbability(final float damage) {
//        final EntityAttributeInstance instance = self.getAttributeInstance(SoulboundArmoryAttributes.GENERIC_CRITICAL_STRIKE_PROBABILITY);
//
//        if (instance != null) {
//            final EntityAttributeModifier modifier = instance.getModifier(SoulboundArmoryAttributes.CRITICAL_STRIKE_PROBABILITY_MODIFIER_ID);
//
//            if (modifier != null) {
//                return modifier.getValue() > self.getRandom().nextDouble() ? 2 * damage : damage;
//            }
//        }
//
//        return damage;

        final EntityAttributeInstance instance = self.getAttributeInstance(SoulboundArmoryAttributes.GENERIC_CRITICAL_STRIKE_PROBABILITY);

        return instance != null && instance.getValue() > this.random.nextDouble() ? 2 * damage : damage;
    }

    @Inject(method = "tick", at = @At("RETURN"))
    public void tick(final CallbackInfo info) {

    }
}
