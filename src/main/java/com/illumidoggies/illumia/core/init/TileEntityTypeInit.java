package com.illumidoggies.illumia.core.init;


import com.illumidoggies.illumia.Illlumia;
import com.illumidoggies.illumia.common.tiles.TestGUIEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeInit {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE = DeferredRegister
			.create(ForgeRegistries.TILE_ENTITIES, Illlumia.MOD_ID);

	public static final RegistryObject<TileEntityType<TestGUIEntity>> TEST_GUI_ENTITY_TYPE = TILE_ENTITY_TYPE
			.register("testgui",
					() -> TileEntityType.Builder.create(TestGUIEntity::new, BlockInit.TestGUIEntity.get()).build(null));
	


}