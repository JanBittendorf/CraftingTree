package CraftingTree.init;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import CraftingTree.item.*;

public class ItemReg {

	public static final ItemManual item_manual = new ItemManual();
	
	public static void init() {
		setName(item_manual, "ctree_manual");
	}
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		registry.register(item_manual);
	}
	
	public static void setName(Item item, String name) {
		item.setRegistryName(new ResourceLocation(CraftingTree.MainConst.MODID, name));
		item.setUnlocalizedName(name);
	}
}