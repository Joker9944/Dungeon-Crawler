package dc.character;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.Set;

import dc.item.Item;

public class CharInventory extends CharBag {

	protected HashMap<InventorySlot, Optional<Item>> inventory = new HashMap<>();
	
	public CharInventory(Race race) {
		super(race);
	}

	public Boolean equipItemFromBag(final String input) {
		Optional<Item> item = isStringItemInArrayList(input, bag);
		if(item.isPresent()) {
			equipItem(item.get());
			return true;
		}
		else {
			System.out.println("Error equipItem(final String item)" + '\n' + "Item not found.");
			return false;
		}
	}
	
	public void equipItem(final Item item) {
		if(isSlotFree(item.getTyp().getSlotType(), inventory)) {
			inventory.put(item.getTyp().getSlotType(), Optional.of(item));
		}
		else {
			System.out.println("Error equipItem(final Item item)" + '\n' + "Slot is taken.");
		}
	}
	
	public Optional<Item> unequipItem(final String input) {
		if(!isBagFull(bag, race)) {
			Optional<InventorySlot> slot = isStringSlot(input, inventory.keySet());
			if(slot.isPresent()) {
				Optional<Item> item = unequipItem(slot.get());
				if(!item.isPresent()) {
					return item;
				}
				return Optional.empty();
			}
			Optional<Item> item = isStringItem(input, inventory.values());
			if(item.isPresent()) {
				item = unequipItem(item.get());
				if(!item.isPresent()) {
					return item;
				}
				return Optional.empty();
			}
			System.out.println("Error unequipItem(final String input)" + '\n' + "Item not found");
			return Optional.empty();
		}
		else {
			System.out.println("Bag is full");
			return Optional.empty();
		}
	}
	
	public Optional<Item> unequipItem(final InventorySlot slot) {
		if(!isSlotFree(slot, inventory)) {
			Item helpItem = inventory.get(slot).get();
			if(addItem(helpItem)) {
				inventory.put(helpItem.getTyp().getSlotType(), Optional.empty());
				return Optional.of(helpItem);
			}
			return Optional.empty();
		}
		else {
			System.out.println("Error unequipItem(final InventorySlot slot)" + '\n' + "Slot es already empty.");
			return Optional.empty();
		}
	}
	
	public Optional<Item> unequipItem(final Item item) {
		if(isItemInInventory(item, inventory.values())) {
			if(addItem(item)) {
				inventory.put(item.getTyp().getSlotType(), Optional.empty());
				return Optional.of(item);
			}
			return Optional.empty();
		}
		else {
			System.out.println("Error unequipItem(final Item item)" + '\n' + "Item not found.");
			return Optional.empty();
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
			return Optional.of(item);
		}
		else {
			System.out.println("Error removeItemInventroy(final Item item)" + '\n' + "Item not found.");
			return Optional.empty();
		}
	}
	
	// Tests
	private Boolean isItemInInventory(final Item item, final Collection<Optional<Item>> items) {
		for(Optional<Item> testItem: items) {
			if(testItem.get() == item) {
				return true;
			}
		}
		return false;
	}
	
	private Optional<InventorySlot> isStringSlot(final String input, final Set<InventorySlot> slot) {
		for(InventorySlot testSlot: slot) {
			if(input.matches("(?i).*" + testSlot.name() + "?")) {
				return Optional.of(testSlot);
			}
			return Optional.empty();
		}
		return Optional.empty();
	}
	
	private Optional<Item> isStringItem(final String input, final Collection<Optional<Item>> items) {
		for(Optional<Item> testItem: items) {
			if(input.matches("(?i).*" + testItem.get().getName() + "?")) {
				return testItem;
			}
			return Optional.empty();
		}
		return Optional.empty();
	}
	
	private Boolean isSlotFree(final InventorySlot slot, final HashMap<InventorySlot, Optional<Item>> inventory) {
		if(inventory.get(slot).isPresent()) {
			return true;
		}
		return false;
	}
	
	// get and set
	public Item getEquipedItem(InventorySlot slot) {
		return inventory.get(slot).get();
	}
}
