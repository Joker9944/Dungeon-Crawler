package dc.character;

import java.util.Collection;
import java.util.HashMap;

import dc.item.Item;
import dc.item.ItemCategory;
import dc.item.ItemTyp;

public class CharInventory extends CharBag {

	protected HashMap<InventorySlot, Item> inventory = new HashMap<>();
	
	public CharInventory(Race race) {
		super(race);
		inventory.put(InventorySlot.HEAD, new Item(ItemCategory.LIGHT, ItemTyp.HELM));
		inventory.put(InventorySlot.CHEST, new Item(ItemCategory.LIGHT, ItemTyp.CHESTPLATE));
		inventory.put(InventorySlot.HANDS, new Item(ItemCategory.LIGHT, ItemTyp.GAUNTLETS));
		inventory.put(InventorySlot.LEGS, new Item(ItemCategory.LIGHT, ItemTyp.LEGINS));
		inventory.put(InventorySlot.WEAPON, new Item(ItemCategory.LIGHT, ItemTyp.DAGGER));
	}

	public Boolean equipItem(final String input) { //TODO Check für einfachere Lösung
		Boolean err1 = true;
		for(Item item: bag) {
			if(testItemString(input, item.getName())) {
				
			}
		}
		
		for(int a = 0; a < bag.size(); a++) {
			if(input.matches(".*" + bag.get(a).getName() + "?")) {
				equipItem(bag.get(a));
				err1 = false;
			}
		}
		if(err1) {
			System.out.println("Error equipItem(final String item)" + '\n' + "Item not found.");
		}
	}
	
	public void unequipItem(final String input) {
		if(!bag.isEmpty()) {
			for(InventorySlot slot: inventory.keySet()) {
				if(testString(input, slot.name())) {
					unequipItem(slot);
				}
			}
			for(Item item: inventory.values()) {
				if(testString(input, item.getName())) {
					unequipItem(inventory.get(item.getTyp().getSlotType()));
				}
			}
			System.out.println("Error unequipItem(final String input)" + '\n' + "Item not found");
		}
		else {
			System.out.println("Bag is full");
		}
	}
	
	public void equipItem(final Item item) {
		if(testSlotFree(item.getTyp().getSlotType(), inventory)) {
			inventory.put(item.getTyp().getSlotType(), item);
		}
		else {
			System.out.println("Error equipItem(final Item item)" + '\n' + "Slot is taken.");
		}
	}
	
	
	
	public void unequipItem(final InventorySlot slot) {
		if(!testSlotFree(slot, inventory)) {
			Item helpItem = inventory.get(slot);
			inventory.put(slot, null);
			bag.add(helpItem);
		}
		else {
			System.out.println("Error unequipItem(final InventorySlot slot)" + '\n' + "Slot es already empty.");
		}
	}
	
	public void unequipItem(final Item item) {
		if(testItem(item, inventory.values())) {
			unequipItem(item.getTyp().getSlotType());
		}
		else {
			System.out.println("Error unequipItem(final Item item)" + '\n' + "Item not found.");
		}
	}
	
	// Tests
	private Boolean testItem(final Item item, final Collection<Item> collection) {
		for(Item aitem: collection) {
			if(aitem == item) {
				return true;
			}
		}
		return false;
	}
	
	private Boolean testSlotFree(final InventorySlot slot, final HashMap<InventorySlot, Item> inventory) {
		if(inventory.get(slot) == null) {
			return true;
		}
		return false;
	}
	
	// get and set
	public Item getEquipedItem(InventorySlot slot) {
		return inventory.get(slot);
	}
	
}
