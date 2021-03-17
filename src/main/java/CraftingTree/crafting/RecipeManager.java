package CraftingTree.crafting;

import org.apache.commons.lang3.ArrayUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class RecipeManager {
	
	// Coverts a string eg. "1xtile.stone@32767" to an itemstack
	public static ItemStack stringToItemStack(String data){
		 try {
		     byte b[] = data.getBytes(); 
		     ByteArrayInputStream bi = new ByteArrayInputStream(b);
		     ObjectInputStream si = new ObjectInputStream(bi);
		     ItemStack obj = (ItemStack) si.readObject();
		     return obj;
		 } catch (Exception e) {
		     System.out.println(e);
		     return null;
		 }
	}
	
	public static ItemStack getFurnaceRecipe(Item item) {
		ItemStack itemStack = new ItemStack(item);
		Set<Entry<ItemStack, ItemStack>> recipes = FurnaceRecipes.instance().getSmeltingList().entrySet();
		
		for (Entry<ItemStack, ItemStack> recipe : recipes) {
			if (recipe.getValue().toString().equalsIgnoreCase(itemStack.toString())) {
				return recipe.getKey();
			}
		}
		
		return null;
	}
}