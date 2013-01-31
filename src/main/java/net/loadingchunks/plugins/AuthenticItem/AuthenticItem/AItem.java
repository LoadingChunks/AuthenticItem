package net.loadingchunks.plugins.AuthenticItem.AuthenticItem;

import net.minecraft.server.v1_4_R1.ItemStack;
import net.minecraft.server.v1_4_R1.NBTTagCompound;
import org.bukkit.craftbukkit.v1_4_R1.inventory.CraftItemStack;

public class AItem {
	
	ItemStack itemstack;
	AuthenticItem plugin;

	public AItem(CraftItemStack item)
	{
		NBTTagCompound tag = CraftItemStack.asNMSCopy(item).getTag();
		
		ItemStack it = CraftItemStack.asNMSCopy(item);
		
		if(tag == null)
			it.setTag(new NBTTagCompound());
		
		this.itemstack = it;
	}
	
	public void setPlugin(AuthenticItem plugin)
	{
		this.plugin = plugin;
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
		this.itemstack.getTag().setString("authentic_type", type);
		this.itemstack.getTag().setInt("RepairCost", 999);
	}
	
	public net.minecraft.server.v1_4_R1.ItemStack getStack()
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
			return null;
		}
		String name = getDisplay().getString("Name");
		
		if(name.equals(""))
		{
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
