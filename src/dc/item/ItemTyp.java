package dc.item;

import dc.character.InventorySlot;

public enum ItemTyp {

	HELM("HELM", InventorySlot.HEAD, 1D),
	CHESTPLATE("CHESTPLATE", InventorySlot.CHEST, 2D),
	GAUNTLETS("GAUNTLETS", InventorySlot.HANDS, 1D),
	GLOVES("GLOVES", InventorySlot.HANDS, 0.2),
	LEGINS("LEGINS", InventorySlot.LEGS, 0.5),
	SWORD("SWORD", InventorySlot.WEAPON, 1D),
	DAGGER("DAGGER", InventorySlot.WEAPON, 0.6),
	AXE("AXE", InventorySlot.WEAPON, 2D),
	BOW("BOW", InventorySlot.WEAPON, 0.9);
	
	private String typ;
	private InventorySlot slotType;
	private Double scaling;
	
	private ItemTyp(String typ, InventorySlot slotType, Double scaling) {
		this.typ = typ;
		this.slotType = slotType;
		this.scaling = scaling;
	}
	
	public String getCategory() {
		return typ;
	}
	
	public InventorySlot getSlotType() {
		return slotType;
	}
	
	public Double getScaling() {
		return scaling;
	}
}