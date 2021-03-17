package CraftingTree.util;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import CraftingTree.gui.GuiCTree;
import CraftingTree.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyHandler {

	@SubscribeEvent
	public void onKeyPress(GuiScreenEvent.KeyboardInputEvent event) {
		if (Main.keyOpenGui.getKeyCode() == Keyboard.getEventKey() && Keyboard.getEventKeyState()) {
			// Cancel event so this doesn't get executed twice
			event.setCanceled(true);
			
			Minecraft mc = Minecraft.getMinecraft();
			
			if (mc.currentScreen instanceof GuiContainer) {
				GuiContainer gui = ((GuiContainer)event.getGui());
				
				if (!(gui == null)) {
					mc.displayGuiScreen(new GuiCTree(gui));
				}
			}
		}
	}
}
