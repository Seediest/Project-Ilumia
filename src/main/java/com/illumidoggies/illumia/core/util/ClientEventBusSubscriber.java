package com.illumidoggies.illumia.core.util;

import com.illumidoggies.illumia.Illlumia;
import com.illumidoggies.illumia.client.screens.TestGUIScreen;
import com.illumidoggies.illumia.core.init.ContainerTypeInit;

import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;;

@Mod.EventBusSubscriber(modid = Illlumia.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ContainerTypeInit.Test_GUI_CONTAINER_TYPE.get(), TestGUIScreen::new);
	}
}
