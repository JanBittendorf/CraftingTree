package CraftingTree;

import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import CraftingTree.MainConst.*;
import CraftingTree.proxy.*;

@Mod(modid = Main.MODID, name = Main.NAME, version = Main.VERSION)
public class Main
{
    public static final String MODID = "crafting_tree";
    public static final String NAME = "CraftingTree";
    public static final String VERSION = "1.0.8";
    
    public static KeyBinding keyOpenGui = new KeyBinding("main.keyBinding.text", Keyboard.KEY_V, "CraftingTree");
    public static Logger logger;
    
    // init proxis
	@SidedProxy(serverSide = "CraftingTree.proxy.CommonProxy", clientSide = "CraftingTree.proxy.ClientProxy")
	private static CommonProxy proxy;

	// Send events to proxi classes
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preinit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
        proxy.postinit(event);
    }
}
