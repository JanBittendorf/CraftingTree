package CraftingTree.proxy;

import net.minecraftforge.common.MinecraftForge;
import CraftingTree.init.*;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preinit(FMLPreInitializationEvent event) {
		
		CraftingTree.init.ItemReg.init();
		MinecraftForge.EVENT_BUS.register(ItemReg.class);
	}

	public void init(FMLInitializationEvent event) {
	}

	public void postinit(FMLPostInitializationEvent event) {
	}
}
