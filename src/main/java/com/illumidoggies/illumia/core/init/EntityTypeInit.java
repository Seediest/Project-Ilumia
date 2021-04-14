package com.illumidoggies.illumia.core.init;

import com.illumidoggies.illumia.Illlumia;
import com.illumidoggies.illumia.common.entities.animal.IllumiPig;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeInit {
	  public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Illlumia.MOD_ID);

	    // Entity Types
	    public static final RegistryObject<EntityType<IllumiPig>> ILLUMIPIG = ENTITY_TYPES.register("illumipig",
	            () -> EntityType.Builder.create(IllumiPig::new, EntityClassification.CREATURE)
	                    .size(1.0f, 1.0f) // Hitbox Size
	                    .build(new ResourceLocation(Illlumia.MOD_ID, "hog").toString()));
	                    
}
