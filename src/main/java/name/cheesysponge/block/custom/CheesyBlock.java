package name.cheesysponge.block.custom;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CheesyBlock extends Block {
    public CheesyBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, Hand hand, BlockHitResult hit) {
        // Called 4 time on right click:
        // 2 Times on the Server (for each Hand)
        // 2 Times on the Client (for each Hand)
        if(world.isClient()) {
            if(hand == Hand.MAIN_HAND) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 300,1));
            } else {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 600,2));
            }
        }

        return ActionResult.PASS;
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(!world.isClient()) {
            if(entity instanceof LivingEntity) {
                LivingEntity livingEntity = ((LivingEntity) entity);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300, 2));
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 300, 2));
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 300));
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 300, 2));
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 300,2));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }
}