package com.illumidoggies.illumia;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import com.illumidoggies.illumia.TutorialMod.TutorialGroup;
import com.illumidoggies.illumia.core.init.BlockInit;
import com.illumidoggies.illumia.core.init.ItemInit;

import java.util.stream.Collectors;
//test this is a test
// The value here should match an entry in the META-INF/mods.toml file
@Mod(Illlumia.MOD_ID)
public class Illlumia
{
	
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "illumidoggies_mod";
    
    public static final ItemGroup TUTORIAL_GROUP = new TutorialGroup("tutorialtab");

   
    public Illlumia() {
        // Register the setup method for modloading
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	bus.addListener(this::setup);
    	ItemInit.ITEMS.register(bus);
    	BlockInit.BLOCKS.register(bus);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    }
    
    
    public static class TutorialGroup extends ItemGroup {

		public TutorialGroup(String label) {
			super(label);
		}

		@Override
		public ItemStack createIcon() {
			return ItemInit.nether_block.get().getDefaultInstance();
		}
		
    }
}
