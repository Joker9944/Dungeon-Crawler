package dc.character;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

import dc.item.Item;

public class CharInventory extends Char {

	//TODO Implement Item Restrictions
	
	protected HashMap<InventorySlot, Optional<Item>> inventory = new HashMap<InventorySlot, Optional<Item>>();
	
	protected CharInventory(Race race) {
		super(race);
		inventory.put(InventorySlot.WEAPON, Optional.empty());
		inventory.put(InventorySlot.HEAD, Optional.empty());
		inventory.put(InventorySlot.CHEST, Optional.empty());
		inventory.put(InventorySlot.HANDS, Optional.empty());
		inventory.put(InventorySlot.LEGS, Optional.empty());
	}
	
	protected CharInventory(String name, Race race) {
		super(name, race);
		inventory.put(InventorySlot.WEAPON, Optional.empty());
		inventory.put(InventorySlot.HEAD, Optional.empty());
		inventory.put(InventorySlot.CHEST, Optional.empty());
		inventory.put(InventorySlot.HANDS, Optional.empty());
		inventory.put(InventorySlot.LEGS, Optional.empty());
	}
	
	public Boolean equipItem(final Item item) {
		if(isSlotFree(item.getTyp().getSlotType(), inventory)) {
			inventory.put(item.getTyp().getSlotType(), Optional.of(item));
			return true;
		}
		else {
			System.out.println("Error equipItem(final Item item)" + '\n' + "Slot is taken.");
			return false;
		}
	}
	
	
	public Optional<Item> removeItemInventroy(final InventorySlot slot) {
		if(!isSlotFree(slot, inventory)) {
			Item helpItem = inventory.get(slot).get();
			inventory.put(helpItem.getTyp().getSlotType(), Optional.empty());
			return Optional.of(helpItem);
		}
		else {
			System.out.println("Error removeItemInventroy(final InventorySlot slot)" + '\n' + "Slot es already empty.");
			return Optional.empty();
		}
	}
	
	public Optional<Item> removeItemInventroy(final Item item) {
		if(isItemInInventory(item, inventory.values())) {
			inventory.put(item.getTyp().getSlotType(), Optional.empty());
			return Optional.of(item);
		}
		else {
			System.out.println("Error removeItemInventroy(final Item item)" + '\n' + "Item not found.");
			return Optional.empty();
		}
	}
	
	// Tests
	protected Boolean isItemInInventory(final Item item, final Collection<Optional<Item>> items) {
		for(Optional<Item> testItem: items) {
			if(testItem.isPresent()) {
				if(testItem.get() == item) {
					return true;
				}
			}
		}
		return false;
	}
	
	protected Optional<InventorySlot> isStringSlot(final String input, final Set<InventorySlot> slot) {
		for(InventorySlot testSlot: slot) {
			if(input.matches("(?i).*" + testSlot.name() + "?")) {
				return Optional.of(testSlot);
			}
			return Optional.empty();
		}
		return Optional.empty();
	}
	
	protected Optional<Item> isStringItem(final String input, final Collection<Optional<Item>> items) {
		for(Optional<Item> testItem: items) {
			if(testItem.isPresent()) {
				if(input.matches("(?i).*" + testItem.get().getName() + "?")) {
					return testItem;
				}
			}
		}
		return Optional.empty();
	}
	
	protected Boolean isSlotFree(final InventorySlot slot, final HashMap<InventorySlot, Optional<Item>> inventory) {
		if(!inventory.get(slot).isPresent()) {
			return true;
		}
		return false;
	}
	
	// get and set
	public Item getEquipedItem(InventorySlot slot) {
		return inventory.get(slot).get();
	}
}
