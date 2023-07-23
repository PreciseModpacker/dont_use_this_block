package fr.shoqapik.blockguis;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

public class BlockGuisConfig {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<List<? extends String>> BANNED_BLOCKS;

    static{
        BUILDER.push("BlockGuis Configuration");
        BANNED_BLOCKS = BUILDER.comment("List of banned blocks gui").defineList("banned_items", Arrays.asList("minecraft:anvil", "minecraft:chipped_anvil", "minecraft:damaged_anvil", "minecraft:enchanting_table", "minecraft:brewing_stand", "minecraft:smithing_table", "cataclysm:mechanical_fusion_anvil"), item -> true);
        BUILDER.pop();
        SPEC = BUILDER.build();
    }

}
