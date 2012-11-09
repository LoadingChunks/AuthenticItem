package net.loadingchunks.plugins.AuthenticItem.AuthenticItem;

import net.minecraft.server.NBTTagCompound;

import org.bukkit.craftbukkit.entity.CraftItem;
import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;

public class AItem {
	
	net.minecraft.server.ItemStack itemstack;

	public AItem(Item item)
	{
		CraftItemStack cstack = new CraftItemStack(item.getItemStack());
		
		NBTTagCompound tag = cstack.getHandle().getTag();
		
		if(tag == null)
			cstack.getHandle().setTag(new NBTTagCompound());
		
		this.itemstack = cstack.getHandle();
	}
	
	public AItem(ItemStack item)
	{
		CraftItemStack cstack = new CraftItemStack(item);
		
		NBTTagCompound tag = cstack.getHandle().getTag();
		
		if(tag == null)
			cstack.getHandle().setTag(new NBTTagCompound());
		
		this.itemstack = cstack.getHandle();
	}

	public String getAuthentic()
	{
		if(this.itemstack.getTag().hasKey("authentic_type"))
			return this.itemstack.getTag().getString("authentic_type");
		else
			return null;
	}
	
	public void setAuthentic(String type)
	{
		NBTTagCompound tags = itemstack.tag;
		tags = itemstack.tag = new NBTTagCompound();
		
		tags.setString("authentic_type", type);
	}
	
	public net.minecraft.server.ItemStack getStack()
	{
		return this.itemstack;
	}
	
	private NBTTagCompound getDisplay()
	{
		return this.itemstack.getTag().getCompound("display");
	}
	
	public String getDisplayName()
	{
		if(getDisplay() == null)
		{
			System.out.println("Nope.");
			return null;
		}
		String name = getDisplay().getString("Name");
		
		if(name.equals(""))
		{
			System.out.println(name);
			return null;
		}
		else
			return name;
	}
	
	public void setDisplayName(String name)
	{
		if(getDisplay() == null)
		{
			this.itemstack.getTag().setCompound("display", new NBTTagCompound());
		}
		
		NBTTagCompound display = getDisplay();

		display.setString("Name", name);
	}
}
