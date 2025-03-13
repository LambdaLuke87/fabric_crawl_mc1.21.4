package net.luke.crawlingchaos.item;

import net.luke.crawlingchaos.CrawlingChaos;
import net.luke.crawlingchaos.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.Map;

public class SerupineaArmorMaterial {
    public static final int SERUPINEA_ARMOR_DURABILITY = 18;
    public static final RegistryKey<EquipmentAsset> SERUPINEA_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(CrawlingChaos.MOD_ID, "serupinea"));

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            SERUPINEA_ARMOR_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 2,
                    EquipmentType.CHESTPLATE, 7,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 2
            ),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            2.0F,
            0.1F,
            ModTags.Items.REPAIRS_SERUPINEA_ARMOR,
            SERUPINEA_ARMOR_MATERIAL_KEY
    );
}