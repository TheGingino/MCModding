package net.ginos.funmod.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.ginos.funmod.item.ModItems;
import net.minecraft.data.server.loottable.EntityLootTableGenerator;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantedCountIncreaseLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModLootTableModifiers {

    private static final RegistryKey<LootTable> HORSE_ID =
            EntityType.HORSE.getLootTableId();
    private static final Logger log = LoggerFactory.getLogger(ModLootTableModifiers.class);

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register((registryKey, builder, lootTableSource, wrapperLookup) -> {
            if (lootTableSource.isBuiltin() && HORSE_ID.equals(registryKey)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.85f))
                        .with(ItemEntry.builder(ModItems.RAW_HORSE))
                        .apply(EnchantedCountIncreaseLootFunction.builder(wrapperLookup, UniformLootNumberProvider.create(0.0F, 1.0F)));
                builder.pool(poolBuilder);
            }
        });
    }
}
