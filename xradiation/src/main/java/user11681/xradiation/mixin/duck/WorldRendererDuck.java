package user11681.xradiation.mixin.duck;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

public interface WorldRendererDuck {
    void drawOutline(BlockState state, BlockPos pos, BlockRenderView world, MatrixStack matrices);
}
