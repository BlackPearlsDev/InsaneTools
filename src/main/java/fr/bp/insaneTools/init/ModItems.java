package fr.bp.insaneTools.init;

import org.apache.logging.log4j.util.TriConsumer;

import fr.bp.insaneTools.InsaneTools;
import fr.bp.insaneTools.common.item.*;
import fr.bp.insaneTools.utils.enums.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.core.registries.BuiltInRegistries;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, InsaneTools.MODID);

    // Tools
    public static final RegistryObject<Item> INSANE_SWORD_TELLURITE = ITEMS.register("insane_sword_tellurite", () -> new TelluriteSword(ItemTiers.INSANE_SWORD_TELLURITE, 30, -1.6f, new Item.Properties().rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> INSANE_PICKAXE_TELLURITE = ITEMS.register("insane_pickaxe_tellurite", () -> new TelluritePickaxe(ItemTiers.INSANE_PICKAXE_TELLURITE, 2, -2.4f, new Item.Properties().durability(-1).rarity(Rarity.EPIC)));
    
    // Items
    public static final RegistryObject<Item> TELLURITE = ITEMS.register("tellurite", () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    
    // Armors
    public static final RegistryObject<Item> TELLURITE_HELMET = ITEMS.register("tellurite_helmet", () -> new TelluriteArmorItem(ArmorTiers.TELLURITE_ARMOR_SET, EquipmentSlot.HEAD, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> TELLURITE_CHEST = ITEMS.register("tellurite_chest", () -> new TelluriteArmorItem(ArmorTiers.TELLURITE_ARMOR_SET, EquipmentSlot.CHEST, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> TELLURITE_LEGS = ITEMS.register("tellurite_legs", () -> new TelluriteArmorItem(ArmorTiers.TELLURITE_ARMOR_SET, EquipmentSlot.LEGS, new Item.Properties().rarity(Rarity.RARE)));
    public static final RegistryObject<Item> TELLURITE_BOOTS = ITEMS.register("tellurite_boots", () -> new TelluriteArmorItem(ArmorTiers.TELLURITE_ARMOR_SET, EquipmentSlot.FEET, new Item.Properties().rarity(Rarity.RARE)));
    
    public static void onRegisterCreativeTabs(TriConsumer<ResourceLocation, RegistryObject<Item>, List<Item>> consumer) {
        consumer.accept(new ResourceLocation(InsaneTools.MODID, "main"), ModItems.INSANE_SWORD_TELLURITE, BuiltInRegistries.ITEM.stream().filter(i -> BuiltInRegistries.ITEM.getKey(i).getNamespace().equals(InsaneTools.MODID)).toList());
    }
}