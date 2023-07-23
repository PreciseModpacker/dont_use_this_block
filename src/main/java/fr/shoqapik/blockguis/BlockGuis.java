package fr.shoqapik.blockguis;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(BlockGuis.MODID)
public class BlockGuis {

    public static final String MODID = "blockguis";

    public BlockGuis()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BlockGuisConfig.SPEC, "block-guis.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onBlockClick(PlayerInteractEvent.RightClickBlock event){
        Level level = event.getLevel();
        BlockState block = level.getBlockState(event.getPos());
        if(!block.isAir() && !level.isClientSide && event.getHand() == InteractionHand.MAIN_HAND) {
            String blockName = Registry.BLOCK.getKey(block.getBlock()).toString();
            if (BlockGuisConfig.BANNED_BLOCKS.get().contains(blockName)) {
                event.getEntity().sendSystemMessage((Component)Component.literal("" + ChatFormatting.RED + blockName + " is blocked."));

                event.setCanceled(true);
            }
        }

    }


}
