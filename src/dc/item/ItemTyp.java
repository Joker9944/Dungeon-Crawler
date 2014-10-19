package dc.item;

import dc.character.CharInventory;

public enum ItemTyp {

	HELM("HELM", CharInventory.InventorySlot.HEAD, 1D),
	CHESTPLATE("CHESTPLATE", CharInventory.InventorySlot.CHEST, 2D),
	GAUNTLETS("GAUNTLETS", CharInventory.InventorySlot.HANDS, 1D),
	GLOVES("GLOVES", CharInventory.InventorySlot.HANDS, 0.2),
	LEGINS("LEGINS", CharInventory.InventorySlot.LEGS, 0.5),
	SWORD("SWORD", CharInventory.InventorySlot.WEAPON, 1D),
	DAGGER("DAGGER", CharInventory.InventorySlot.WEAPON, 0.6),
	AXE("AXE", CharInventory.InventorySlot.WEAPON, 2D),
	BOW("BOW", CharInventory.InventorySlot.WEAPON, 0.9);
	
	private String typ;
	private CharInventory.InventorySlot slotType;
	private Double scaling;
	
	private ItemTyp(String typ, CharInventory.InventorySlot slotType, Double scaling) {
		this.typ = typ;
		this.slotType = slotType;
		this.scaling = scaling;
	}
	
	public String getCategory() {
		return typ;
	}
	
	public CharInventory.InventorySlot getSlotType() {
		return slotType;
	}
	
	public Double getScaling() {
		return scaling;
	}
}