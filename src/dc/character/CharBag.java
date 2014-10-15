package dc.character;

import java.util.ArrayList;

import dc.item.Item;

public class CharBag extends Char {

	protected ArrayList<Item> bag = new ArrayList<>();
	
	public CharBag(Race race) {
		super(race);
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
	
	public Boolean removeItem(final String input) {
		if(!bag.isEmpty()) {
			for(Item test: bag) {
				if(testItemString(input, test.getName())) {
					bag.remove(test);
					return true;
				}
			}
			System.out.println("Error removeItem(final String input)" + '\n' + "Item not found.");
			return false;
		}
		else {
			System.out.println("Error removeItem(final String input)" + '\n' + "Bag is already empty");
			return false;
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
	
	// Tests
	protected Boolean isBagFull(final ArrayList<Item> bag, Race race) {
		if(bag.size()<=race.getMaxBagSlots()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	protected Boolean testItemString(final String input, final String test) {
		if(input.matches("(?i).*" + test + "?")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	protected Item isItemInBag(final String input, final ArrayList<Item> bag) {
		for(Item item: bag) {
			if(input.matches("(?i).*" + item.getName() + "?")) {
				return item;
			}
			return null;
		}
		return null;
	}
}