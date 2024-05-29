package io.github.louisdufourd.core.material;

import io.github.louisdufourd.Univers;
import io.github.louisdufourd.core.init.ItemInit;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterial {
    public static final Holder<ArmorMaterial> PLATINUM_ARMOR_MATERIAL = register("platinum", new ArmorMaterial(
            Util.make(
                    new EnumMap<>(ArmorItem.Type.class),
                    map -> {
                        map.put(ArmorItem.Type.BOOTS, 3);
                        map.put(ArmorItem.Type.LEGGINGS, 6);
                        map.put(ArmorItem.Type.CHESTPLATE, 8);
                        map.put(ArmorItem.Type.HELMET, 3);
                        map.put(ArmorItem.Type.BODY,11);
                    }
            ),
            15,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            () -> Ingredient.of(ItemInit.PLATINUM_INGOT.get()),
            List.of(
                    new ArmorMaterial.Layer(
                            new ResourceLocation(Univers.MOD_ID, "platinum")
                    ),
                    new ArmorMaterial.Layer(
                            new ResourceLocation(Univers.MOD_ID, "platinum"), "_overlay", true
                    )
            ),
            2.5F,
            0.05F
    ));

    private static Holder<ArmorMaterial> register(String name, ArmorMaterial material) {

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, new ResourceLocation(Univers.MOD_ID, name), material);
    }
}
