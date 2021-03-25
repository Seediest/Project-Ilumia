package com.illumidoggies.illumia.core.init;

import com.illumidoggies.illumia.Illlumia;
import com.illumidoggies.illumia.common.containers.TestGUIContainer;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypeInit {
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister
			.create(ForgeRegistries.CONTAINERS, Illlumia.MOD_ID);
	
	public static final RegistryObject<ContainerType<TestGUIContainer>> Test_GUI_CONTAINER_TYPE = CONTAINER_TYPES
			.register("testgui", () -> IForgeContainerType.create(TestGUIContainer::new));
}
