package fr.bp.insaneTools.common.item;

import fr.bp.insaneTools.InsaneTools;
import fr.bp.insaneTools.init.ModItems;
import fr.bp.insaneTools.utils.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.*;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TelluriteArmorItem extends ArmorItem {

    public TelluriteArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    protected void addAdditionalInformation(List<Component> list) {
        // volontarily empty
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        addAdditionalInformation(tooltip);
        tooltip.add(LocalizeUtils.fullSet());
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {

        boolean isFullSet = player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.TELLURITE_HELMET.get() && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.TELLURITE_CHEST.get() && player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.TELLURITE_LEGS.get() && player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.TELLURITE_BOOTS.get();

        if(isFullSet) {
            // player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20));
            onLivingHurtEvent(new LivingDamageEvent(player, DamageSource.GENERIC, 1));
        }
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingDamageEvent event) {
        if(event.getSource().getEntity() instanceof LivingEntity) {
            // LivingEntity target = event.getEntity();
            float amount = event.getAmount();
            LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
            Item boots = attacker.getItemBySlot(EquipmentSlot.FEET).getItem();
            Item legs = attacker.getItemBySlot(EquipmentSlot.LEGS).getItem();
            Item body = attacker.getItemBySlot(EquipmentSlot.CHEST).getItem();
            Item helmet = attacker.getItemBySlot(EquipmentSlot.HEAD).getItem();
            DamageSource source = event.getSource();

            if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(InsaneTools.MODID, "tellurite_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(InsaneTools.MODID, "tellurite_chest")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(InsaneTools.MODID, "tellurite_legs")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(InsaneTools.MODID, "tellurite_helmet"))) {
                if (((attacker instanceof Player) && !source.isProjectile() && !source.isMagic())) {
                    event.setAmount(amount + 16);
                    return;
                }
            }
        }
    }


    @Override
    public boolean isRepairable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isValidRepairItem(ItemStack tool, ItemStack material) {
        return material.getItem() == ModItems.TELLURITE.get();
    }
}
