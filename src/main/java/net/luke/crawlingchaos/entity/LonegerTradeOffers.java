package net.luke.crawlingchaos.entity;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.luke.crawlingchaos.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.provider.EnchantmentProvider;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.*;
import net.minecraft.world.World;

import java.util.Optional;

public class LonegerTradeOffers extends TradeOffers {

    public LonegerTradeOffers() {
    }

    public static final Int2ObjectMap<Factory[]> LONEGER_TRADES;

    static {
        LONEGER_TRADES = copyToFastUtilMap(ImmutableMap.of(1, new Factory[]{
                        new SellItemCustom(ModItems.SERUPINEA_UPGRADE_SMITHING_TEMPLATE, 12, 1, 5, 1),
                        new BuyCustom(ModItems.BLIGHT_ROTTEN_FLESH, 16, 5, 5, 2),
                        new SellItemCustom(ModItems.JELLY_APPLE, 2, 6, 5, 1),
                        new SellItemCustom(ModItems.FORMULA_MOONLIGTH, 1, 1, 5, 1),
                        new SellItemCustom(ModItems.FORMULA_PURIFICATION, 1, 1, 5, 1),
                        new SellItemCustom(ModItems.FORMULA_POISON_VERMILION, 1, 1, 5, 1),
                        new SellItemCustom(ModItems.GROWTH_ORGAN, 1, 4, 5, 1),
                        new SellItemCustom(ModItems.STORAGE_ORGAN, 2, 5, 5, 1),
                        new SellItemCustom(ModItems.STORAGE_ORGAN_POISON, 2, 4, 5, 1)},
                2, new Factory[]{
                        new BuyCustom(ModItems.ACARUS_CHITIN, 8, 5, 5, 1),
                        new BuyCustom(ModItems.PARASITE_TOOTH, 6, 5, 5, 1),
                        new BuyCustom(ModItems.SERUPINEA_EXOSKELETON, 12, 5, 5, 2),
                        new BuyCustom(ModItems.KNIGHT_EXOSKELETON, 5, 5, 5, 4)}));
    }

    public static class BuyCustom implements Factory {
        private final TradedItem stack;
        private final int maxUses;
        private final int experience;
        private final int price;
        private final float multiplier;

        public BuyCustom(ItemConvertible item, int count, int maxUses, int experience) {
            this(item, count, maxUses, experience, 1);
        }

        public BuyCustom(ItemConvertible item, int count, int maxUses, int experience, int price) {
            this(new TradedItem(item.asItem(), count), maxUses, experience, price);
        }

        public BuyCustom(TradedItem stack, int maxUses, int experience, int price) {
            this.stack = stack;
            this.maxUses = maxUses;
            this.experience = experience;
            this.price = price;
            this.multiplier = 0.05F;
        }

        public TradeOffer create(Entity entity, Random random) {
            return new TradeOffer(this.stack, new ItemStack(ModItems.CRYSTALS_OF_VIRUS, this.price), this.maxUses, this.experience, this.multiplier);
        }
    }

    public static class SellItemCustom implements TradeOffers.Factory {
        private final ItemStack sell;
        private final int price;
        private final int maxUses;
        private final int experience;
        private final float multiplier;
        private final Optional<RegistryKey<EnchantmentProvider>> enchantmentProviderKey;

        public SellItemCustom(Block block, int price, int count, int maxUses, int experience) {
            this(new ItemStack(block), price, count, maxUses, experience);
        }
        public SellItemCustom(Item item, int price, int count, int experience) {
            this((ItemStack)(new ItemStack(item)), price, count, 12, experience);
        }
        public SellItemCustom(Item item, int price, int count, int maxUses, int experience) {
            this(new ItemStack(item), price, count, maxUses, experience);
        }
        public SellItemCustom(ItemStack stack, int price, int count, int maxUses, int experience) {
            this(stack, price, count, maxUses, experience, 0.05F);
        }
        public SellItemCustom(Item item, int price, int count, int maxUses, int experience, float multiplier) {
            this(new ItemStack(item), price, count, maxUses, experience, multiplier);
        }
        public SellItemCustom(Item item, int price, int count, int maxUses, int experience, float multiplier, RegistryKey<EnchantmentProvider> enchantmentProviderKey) {
            this(new ItemStack(item), price, count, maxUses, experience, multiplier, Optional.of(enchantmentProviderKey));
        }
        public SellItemCustom(ItemStack stack, int price, int count, int maxUses, int experience, float multiplier) {
            this(stack, price, count, maxUses, experience, multiplier, Optional.empty());
        }
        public SellItemCustom(ItemStack sell, int price, int count, int maxUses, int experience, float multiplier, Optional<RegistryKey<EnchantmentProvider>> enchantmentProviderKey) {
            this.sell = sell;
            this.price = price;
            this.sell.setCount(count);
            this.maxUses = maxUses;
            this.experience = experience;
            this.multiplier = multiplier;
            this.enchantmentProviderKey = enchantmentProviderKey;
        }

        public TradeOffer create(Entity entity, Random random) {
            ItemStack itemStack = this.sell.copy();
            World world = entity.getWorld();
            this.enchantmentProviderKey.ifPresent((key) -> EnchantmentHelper.applyEnchantmentProvider(itemStack, world.getRegistryManager(), key, world.getLocalDifficulty(entity.getBlockPos()), random));
            return new TradeOffer(new TradedItem(ModItems.CRYSTALS_OF_VIRUS, this.price), itemStack, this.maxUses, this.experience, this.multiplier);
        }
    }

    private static Int2ObjectMap<Factory[]> copyToFastUtilMap(ImmutableMap<Integer, Factory[]> map) {
        return new Int2ObjectOpenHashMap<>(map);
    }
}