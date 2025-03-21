package net.luke.crawlingchaos.item;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class KnightArmorMaterial {
    public static final int KNIGHT_ARMOR_DURABILITY = 32;
    public static final RegistryKey<EquipmentAsset> KNIGHT_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(CrawlingChaos.MOD_ID, "knight"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            KNIGHT_ARMOR_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            25,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            3.0F,
            0.2F,
            ModTags.Items.REPAIRS_KNIGHT_ARMOR,
            KNIGHT_ARMOR_MATERIAL_KEY
    );
}