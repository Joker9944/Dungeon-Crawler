package dc.character;

import java.util.ArrayList;
import java.util.Optional;
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
	
	// Tests
	protected Boolean isBagFull(final ArrayList<Item> bag, Race race) {
		if(bag.size()<=race.getMaxBagSlots()) {
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
}