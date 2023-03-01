package fr.bp.insaneTools.common.item;

import fr.bp.insaneTools.init.ModItems;
import fr.bp.insaneTools.utils.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TelluritePickaxe extends PickaxeItem {
    
    public TelluritePickaxe(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    protected void addAdditionalInformation(List<Component> list) {
        // volontarily empty
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        // super.appendHoverText(stack, worldIn, tooltip, flagIn);
        // tooltip.add(Component.nullToEmpty("§7§oCette pioche vous permettra de miner de nombreux minerais !"));
        addAdditionalInformation(tooltip);
        tooltip.add(LocalizeUtils.infiniteUses());
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
