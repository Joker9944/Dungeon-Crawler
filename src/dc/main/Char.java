package dc.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Char {

	private String name;
	private Race race;
	private Integer HP;
	private Integer MP;
	private HashMap<InventorySlot, Item> inventory = new HashMap<>();
	private ArrayList<Item> bag = new ArrayList<>();
	
	public Char(Race race) {
		creat(race.getRace(), race);
	}
	
	public Char(String name, Race race) {
		creat(name, race);
	}
	
	private void creat(String name, Race race) {
		this.name = name;
		this.race = race;
		HP = race.getMaxHP();
		MP = race.getMaxMP();
		inventory.put(InventorySlot.HEAD, new Item(ItemCategory.LIGHT, ItemTyp.HELM));
		inventory.put(InventorySlot.CHEST, new Item(ItemCategory.LIGHT, ItemTyp.CHESTPLATE));
		inventory.put(InventorySlot.HANDS, new Item(ItemCategory.LIGHT, ItemTyp.GAUNTLETS));
		inventory.put(InventorySlot.LEGS, new Item(ItemCategory.LIGHT, ItemTyp.LEGINS));
		inventory.put(InventorySlot.WEAPON, new Item(ItemCategory.LIGHT, ItemTyp.DAGGER));
	}
	
	//bag
	public void showBag() {
		if(!testBagEmpty(bag)) {
			for(int i = 0; i < bag.size(); i++) {
				System.out.println(bag.get(i).getName());
			}
		}
	}
	
	public void addItem(final Item item) {
		if(!testBagFull(bag)) {
			bag.add(item);
		}
		else {
			System.out.println("Error addItem(final Item item)" + '\n' + "Bag is full");
		}
	}
	
	public void removeItem(final String input) {
		Boolean err = true;
		if(!testBagEmpty(bag)) {
			for(int a = 0; a < bag.size(); a++) {
				if(testString(input, bag.get(a).getName())) {
					
					err = false;
				}
			}
			if(err) {
				System.out.println("Error removeItem(final String input)" + '\n' + "Item not found.");
			}
		}
		else {
			System.out.println("Error removeItem(final String input)" + '\n' + "Bag is already empty");
		}
	}
	
	public void removeItem(final Item item) {
		if (bag.indexOf(item) >= 0){
			bag.remove(item);
		}
		else {
			System.out.println("Error removeItem(Item)" + '\n' + "Item not found.");
		}
	}
	
	public void equipItem(final String input) { //TODO Check für einfachere Lösung
		Boolean err1 = true;
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
		if(!testBagFull(bag)) {
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
	
	//inventory
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
	
	
	//tests
	private Boolean testBagFull(ArrayList<Item> bag) {
		if(bag.size() >= race.getMaxBagSlots()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private Boolean testBagEmpty(final ArrayList<Item> bag) {
		if(bag.size() <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private Boolean testString(final String input, final String test) {
		if(input.matches("(?i).*" + test + "?")) {
			return true;
		}
		else {
			return false;
		}
	}
	
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
	
	//get and set
	public String getName() {
		return name;
	}

	public Race getRace() {
		return race;
	}

	public Integer getMaxHP() {
		return race.getMaxHP();
	}

	public Integer getHP() {
		return HP;
	}

	public void setHP(Integer HP) {
		this.HP = HP;
	}

	public Integer getMaxMP() {
		return race.getMaxMP();
	}
	
	public Integer getMP() {
		return MP;
	}

	public void setMP(Integer MP) {
		this.MP = MP;
	}

	public Boolean getClm() {
		return race.getClm();
	}

	public Item getEquipedItem(InventorySlot slot) {
		return inventory.get(slot);
	}
}
