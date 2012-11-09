package net.loadingchunks.plugins.AuthenticItem.AuthenticItem;

import org.bukkit.ChatColor;

public enum AuthenticTypes {
	AUTHENTIC(ChatColor.DARK_PURPLE + "Authentic"),COMMUNITY(ChatColor.GREEN + "Community"),SPOOKY(ChatColor.GOLD + "Spooky"),FESTIVE(ChatColor.DARK_RED + "Festive" + ChatColor.DARK_GREEN),UNIQUE(ChatColor.BLUE + "Unique"),UNUSUAL(ChatColor.LIGHT_PURPLE + "Unusual");
	
	private AuthenticTypes(final String str)
	{
		this.text = str;
	}
	
	private final String text;
	
	@Override
	public String toString() {
		return text;
	}
}
