package CraftingTree.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import CraftingTree.init.*;
import CraftingTree.util.KeyHandler;

public class ClientProxy extends CommonProxy{

	public void preinit(FMLPreInitializationEvent event) {
		
		MinecraftForge.EVENT_BUS.register(ItemModels.class);
		super.preinit(event);
	}

	public void init(FMLInitializationEvent event) {
		
		ClientRegistry.registerKeyBinding(CraftingTree.Main.keyOpenGui);
		MinecraftForge.EVENT_BUS.register(new KeyHandler());
		super.init(event);
	}

	public void postinit(FMLPostInitializationEvent event) {
		
		super.postinit(event);
	}
}
