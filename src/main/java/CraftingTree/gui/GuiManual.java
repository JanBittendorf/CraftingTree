package CraftingTree.gui;

import java.io.IOException;
import java.util.Dictionary;
import javax.swing.plaf.basic.BasicListUI.FocusHandler;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiManual extends GuiScreen{
	
	final ResourceLocation texture = new ResourceLocation(CraftingTree.MainConst.MODID, "textures/gui/manual.png");
    
	@Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) throws NullPointerException {
    	
		// Get text from lang file and insert current keyBinding
    	String message = new TextComponentTranslation("gui.manual.text", Keyboard.getKeyName(CraftingTree.Main.keyOpenGui.getKeyCode())).getUnformattedText();
    	
    	// Init vars
    	int textureFileOffsetX = 20; int textureFileOffsetY = 1;
    	int textureWidth = 145; int textureHeight = 179;
    	int leftWhileCentered = (width / 2 - textureWidth / 2);
    	int topWhileCenetered = (height / 2 - textureHeight / 2);
    	
    	// Draw background (with failsafe)
    	try {
    		drawDefaultBackground();
    	} catch (NullPointerException e) {
    		CraftingTree.Main.logger.warn("Fail! Exiting...");
    		return;
    	}
    	
    	// Draw Texture
    	Minecraft.getMinecraft().renderEngine.bindTexture(texture);
    	
    	drawTexturedModalRect(leftWhileCentered,  topWhileCenetered,
    						  textureFileOffsetX, textureFileOffsetY,
    						  textureWidth,       textureHeight);
    	
    	// Draw Strings on gui
    	String text = "";
    	int index = 0;
    	
    	for (int i=0; i<message.length(); i++) {
    		text = "";
    		
    		while (message.split(" ").length > index && (text.length() + message.split(" ")[index].length() < 25)) {
    			text += " " + message.split(" ")[index];
    			index++;
    		}
    		
    		fontRenderer.drawString(text, (leftWhileCentered + 5), (topWhileCenetered + (i + 1) * 10), 0x916036, false);
    	}
    	
		super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
	// Bind 'esc' and 'e' to closing the gui
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
    	
    	if (keyCode == Keyboard.KEY_E || keyCode == Keyboard.KEY_ESCAPE) {
    		Minecraft.getMinecraft().player.closeScreen();
    	}
    }
}
