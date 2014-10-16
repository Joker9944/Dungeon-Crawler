package dc.character;

import java.util.ArrayList;
import java.util.Optional;

import dc.item.Item;

public class CharBag extends CharInventory {

	protected ArrayList<Item> bag = new ArrayList<>();
	
	protected CharBag(Race race) {
		super(race);
	}
	
	protected CharBag(String name, Race race) {
		super(name, race);
	}
	
	public void showBag() {
		if(!bag.isEmpty()) {
			for(int i = 0; i < bag.size(); i++) {
				System.out.println(bag.get(i).getName());
			}
		}
		else {
			System.out.println("Error showBag()" + '\n' + "Bag is empty");
		}
	}
	
	public Boolean addItem(final Item item) {
		if(!isBagFull(bag, race)) {
			bag.add(item);
			return true;
		}
		else {
			System.out.println("Error addItem(final Item item)" + '\n' + "Bag is full");
			return false;
		}
	}
	
	public Optional<Item> removeItem(final String input) {
		if(!bag.isEmpty()) {
			Optional<Item> item = isStringItemInArrayList(input, bag);
			if(item.isPresent()) {
				bag.remove(item.get());
				return item;
			}
			System.out.println("Error removeItem(final String input)" + '\n' + "Item not found.");
			return Optional.empty();
		}
		else {
			System.out.println("Error removeItem(final String input)" + '\n' + "Bag is already empty");
			return Optional.empty();
		}
	}
	
	public Boolean removeItem(final Item item) {
		if (bag.indexOf(item) >= 0){
			bag.remove(item);
			return true;
		}
		else {
			System.out.println("Error removeItem(Item)" + '\n' + "Item not found.");
			return false;
		}
	}
	
	// Methods used to equip/unequip from Bag/ into bag
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
	
	// Tests
	protected Boolean isBagFull(final ArrayList<Item> bag, Race race) {
		if(bag.size()>=race.getMaxBagSlots()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	protected Optional<Item> isStringItemInArrayList(final String input, final ArrayList<Item> bag) {
		for(Item item: bag) {
			if(input.matches("(?i).*" + item.getName() + "?")) {
				return Optional.of(item);
			}
			return Optional.empty();
		}
		return Optional.empty();
	}
	
	// Get and Set
	public ArrayList<Item> getBag() {
		return bag;
	}
}