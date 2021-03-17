package CraftingTree.gui;

import java.io.IOException;
import org.lwjgl.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCTree extends GuiScreen{
	// get tree once to not cause any lags
	public GuiCTree(GuiContainer gui) {
		// get item under mouse
		Slot slot = gui.getSlotUnderMouse();
		Item item = slot.getStack().getItem();
		ResourceLocation itemID = item.getRegistryName();
		String itemName = item.getItemStackDisplayName(slot.getStack());

		// create variables
		public boolean wasShortened = false;

		// create ressource tree
		int maxTreeSize = 256;
		public Object[][] tree = new Object[maxTreeSize][2];


	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		// Main code here
		drawRect(0, 0, 100, 100, 0xFFFFFF);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
    
	// Bind 'esc' and 'e' to closing the gui
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
    	
    	if (keyCode == Keyboard.KEY_E || keyCode == Keyboard.KEY_ESCAPE) {
    		Minecraft.getMinecraft().player.closeScreen();
    	}
    }
}
