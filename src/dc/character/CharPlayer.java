package dc.character;

import java.util.Optional;

import dc.item.Item;

public class CharPlayer extends CharBag{

	protected CharPlayer(String name, Race race) {
		super(name, race);
	}
	
	// Some methods to work with a string.
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
}
