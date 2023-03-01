package fr.bp.insaneTools.utils;

import net.minecraft.*;
import net.minecraft.network.chat.*;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.item.*;

public class LocalizeUtils {

    private static final MutableComponent

    InfiniteUses = MutableComponent.create(new TranslatableContents("tooltip.uses.infinite")),
    NoProtection = MutableComponent.create(new TranslatableContents("tooltip.noprotection")),
    SingleUse = MutableComponent.create(new TranslatableContents("tooltip.uses.single")),
    FullSet = MutableComponent.create(new TranslatableContents("tooltip.fullset"));
    

    private static final String RemainingUses = "tooltip.uses",
    DamageReductionStringFormat = "tooltip.damage.reduction",
    Ammo = "tooltip.ammo",
    MeleeDamage = "tooltip.damage.melee",
    BowDamage = "tooltip.damage.ranged",
    // RangedAndMeleeDamage = "tooltip.damage.both",
    Efficency = "tooltip.efficiency",
    HarvestLevel = "tooltip.harvest_level";

    public static TranslatableContents getArmorAbility(String keyPart, Object... params) {
        String id = String.format("tooltip.armor_info.%s", keyPart);

        return params == null || params.length < 1
                ? new TranslatableContents(id)
                : new TranslatableContents(id, params);
    }

    public static Component usesRemaining(int uses) {
        return i18n(RemainingUses, uses);
    }

    public static Component infiniteAmmo() {
        return LocalizeUtils.i18n("tooltip.ammo.infinite");

    }

    public static Component ammo(Item ammo) {
        return ammo(ammo, ChatFormatting.GRAY);
    }

    public static Component ammo(Item ammo, boolean isPresent) {
        return ammo(ammo, isPresent ? ChatFormatting.GREEN : ChatFormatting.RED);
    }

    public static Component ammo(Item ammo, ChatFormatting formatting) {
        Component ammoName = MutableComponent.create(new TranslatableContents(ammo.getDescriptionId()));
        ammoName.getStyle().applyFormat(formatting);

        return i18n(Ammo, ammoName);
    }

    public static Component bowDam(String dam) {
        return i18n(BowDamage, dam);
    }

    public static Component infiniteUses() {
        return InfiniteUses.withStyle(ChatFormatting.BLUE);
    }

    public static Component fullSet() {
        return FullSet.withStyle(ChatFormatting.BLUE);
    }

    public static Component damageReduction(double reduct, double fullReduct) {
        return i18n(DamageReductionStringFormat, reduct, fullReduct);
    }

    public static Component efficiency(double eff) {
        return i18n(Efficency, eff);
    }

    public static Component harvestLevel(int lvl) {
        return i18n(HarvestLevel, lvl);
    }

    public static Component singleUse() {
        return SingleUse;
    }

    public static Component meleeDam(double dam) {
        return i18n(MeleeDamage, dam);
    }

    public static Component rangedDam(double dam) {
        return i18n(BowDamage, dam);
    }

    public static Component noProtection() {
        return NoProtection;
    }

    public static ComponentContents normal(String message) {
        return normal(message, ChatFormatting.WHITE);
    }

    public static ComponentContents normal(String message, ChatFormatting format) {
        MutableComponent text = MutableComponent.create(new TranslatableContents(message));
        text.withStyle(format);

        return text.getContents();
    }

    public static Component i18n(String text, Object... args) {
        MutableComponent result = MutableComponent.create(new TranslatableContents(text, args));
        return result.withStyle(ChatFormatting.GRAY);
    }

    public static Component i18n(ChatFormatting color, String text, Object... args) {
        MutableComponent result = MutableComponent.create(new TranslatableContents(text, args));
        return result.withStyle(color);
    }
}
