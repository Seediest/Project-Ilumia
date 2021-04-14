package com.illumidoggies.illumia;

import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.illumidoggies.illumia.common.entities.animal.IllumiPig;
import com.illumidoggies.illumia.core.init.ArmorInit;
//import com.illumidoggies.illumia.TutorialMod.TutorialGroup;
import com.illumidoggies.illumia.core.init.BlockInit;
import com.illumidoggies.illumia.core.init.ContainerTypeInit;
import com.illumidoggies.illumia.core.init.EntityTypeInit;
import com.illumidoggies.illumia.core.init.ItemInit;
import com.illumidoggies.illumia.core.init.TileEntityTypeInit;
import com.illumidoggies.illumia.core.init.ToolInit;
import com.illumidoggies.illumia.core.init.WeaponInit;

//test this is a test
// The value here should match an entry in the META-INF/mods.toml file
@Mod(Illlumia.MOD_ID)
public class Illlumia
{
	
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "illumidoggies_mod";
    
    public static final ItemGroup TUTORIAL_GROUP = new TutorialGroup("TutorialTab");
    public static final ItemGroup FINISHED_GROUP = new FinishedGroup("FinishedTab");
   
    public Illlumia() {
        // Register the setup method for modloading
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	bus.addListener(this::setup);
    	ItemInit.ITEMS.register(bus);
    	BlockInit.BLOCKS.register(bus);
    	WeaponInit.ITEMS.register(bus);
    	ToolInit.ITEMS.register(bus);
    	ArmorInit.ITEMS.register(bus);
    	TileEntityTypeInit.TILE_ENTITY_TYPE.register(bus);
    	ContainerTypeInit.CONTAINER_TYPES.register(bus);
    	EntityTypeInit.ENTITY_TYPES.register(bus);
    	
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        GeckoLib.initialize();

    }

    @SuppressWarnings("deprecation")
	private void setup(final FMLCommonSetupEvent event)
    {
    	DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(EntityTypeInit.ILLUMIPIG.get(), IllumiPig.setCustomAttributes().create());
        });
    }
    
    
    public static class TutorialGroup extends ItemGroup {

		public TutorialGroup(String label) {
			super(label);
		}

		@Override
		public ItemStack createIcon() {
			return ItemInit.TestGUI.get().getDefaultInstance();
		}
		
		
    }
    public static class FinishedGroup extends ItemGroup {

		public FinishedGroup(String label) {
			super(label);
		}

		@Override
		public ItemStack createIcon() {
			return ItemInit.nether_block.get().getDefaultInstance();
		}
    }
}
