package fr.bp.insaneTools.init;

import fr.bp.insaneTools.InsaneTools;
import fr.bp.insaneTools.blocks.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, InsaneTools.MODID);

    public static final RegistryObject<Block> TELLURITE_ORE_BLOCK = createBlock("tellurite_ore_block", () -> new TelluriteOreBlock());
    public static final RegistryObject<Block> TELLURITE_BLOCK = createBlock("tellurite_block", () -> new Block(Block.Properties.of(Material.METAL).strength(0.5f, 6.0f).sound(SoundType.METAL)));

    public static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> supplier)
    {
        RegistryObject<Block> block = BLOCKS.register(name, supplier);
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
}
