package dc.main;

import java.util.Optional;

import dc.character.CharBag;
import dc.character.CharInventory;
import dc.character.Race;
import dc.item.Item;
import dc.utils.ConsoleReader;
import dc.utils.RandomGenerator;

public class Menu {

	private static Location direction[] = new Location[] {Location.CORRIDOR, Location.CORRIDOR, Location.CORRIDOR};
	private static CharBag player;
	
	static Encounter encounter;
	
	public static void main(String[] args) {
		String input;

		System.out.println("Dungeon Crawler");
		System.out.println("help for commands");
		System.out.println("help <command> for help about command");
		System.out.println('\n' + "Character creaton:");
		String name = ConsoleReader.readString("Name:");
		System.out.println("Choose your race.");
		while(player == null) {
			input = ConsoleReader.readString("Select");
			for (Race race: Race.values()) {
				if(input.matches("(?i)^" + race.getRace() + "?")) {
					player = (CharBag) Race.getNewChar(name, race);
					for(Item item: player.getRace().getStartItems()) {
						player.equipItem(item);
					}
				}
			}
			if(input.matches("^help.*")) {
				Text.helpCreat(input);
			}
		}
		player.setHP(player.getRace().getMaxHP());
		player.setMP(player.getRace().getMaxMP());
		System.out.println("Chracter created");
		while (player.getHP() > 0) {
			input = ConsoleReader.readString("Select");
			// Move
			move(input);
			// Bag
			bag(input);
			// Rest
			rest(input);
			// Search
			search(input);
			// Status
			status(input);
			// help
			if(input.matches("^help.*|^help")) {
				Text.helpMenu(input);
			}
		}
	}
	
	private static Boolean move(String input) {
		if(input.matches("^move.*|^move")) {
			if(input.matches("^move")) {
				System.out.println("Enter Direction or objekt where you want to move to.");
				return true;
			}
			if(input.matches(".*wall?")) {
				System.out.println("You can't go that way.");
				return true;
				
			}
			for(Location direction: Location.values()) {
				if(input.matches(".*" + direction)) {
					encounterCalc(direction);
					setNewDirections();
					return true;
				}
			}
		}
		return false;
	}
	
	protected static Boolean bag(String input) {
		if(input.matches("^bag.*|^bag")) {
			if(input.matches(".*show?|^bag")) {
				player.showBag();
				return true;
			}
			if(input.matches(".*drop.*")) {
				player.removeItem(input);
				System.out.println(input);
				return true;
			}
			if(input.matches(".*equip.*")) {
				player.equipItemFromBag(input);
				System.out.println(input);
				return true;
			}
			if(input.matches(".*unequip.*")) {
				player.unequipItem(input);
				System.out.println(input);
				return true;
			}
		}
		return false;
	}
	
	private static Boolean rest(String input) {
		if(input.matches("^rest")) {
			if(RandomGenerator.randomInteger(0, 100) <= 30) {
				//TODOencounterCalc(100, "Rest");
			}
			else {
				Double t;
				Double m;
				t = ((player.getRace().getMaxHP() - player.getHP()) / 3D);
				m = ((player.getRace().getMaxMP() - player.getMP()) / 5D);
				player.setHP(player.getHP() + t);
				player.setMP(player.getMP() + t);
				System.out.println("You have restet and restort " + t + " TP and "
						+ m + " MP.");
			}
			return true;
		}
		return false;
	}
	
	private static Boolean search(String input) {
		if(input.matches("^search")) {
			Integer i = RandomGenerator.randomInteger(0, 100);
			if(i >= 0 && i <= 80) {
				Text.move(direction);
			}
			if(i >= 81 && i <= 95) {
				Encounter.encounter(Location.CORRIDOR, player);
			}
			if(i >= 96 && i <= 100) {
				//TODO loot
				System.out.println("Loot");
			}
			return true;
		}
		return false;
	}
	
	protected static Boolean status(String input) {
		if(input.matches("^status")) {
			System.out.println(player.getName());
			System.out.println(player.getRace().getRace());
			System.out.println("HP: " + player.getHP());
			if(player.getClm().equals(true)) {
				System.out.println("MP: " + player.getMP());
			}
			//TODO No equiment when nothing equiped
			System.out.println('\n' + "Equipment:");
			for(CharInventory.InventorySlot slot: CharInventory.InventorySlot.values()) {
				Optional<Item> helpContainer = player.getEquipedItem(slot);
				if(helpContainer.isPresent()) {
					System.out.println(helpContainer.get().getName());
					if(slot.equals(CharInventory.InventorySlot.WEAPON)) {
						System.out.println("Damage: " + helpContainer.get().getValue());
					} else {
						System.out.println("Armor: " + helpContainer.get().getValue());
					}
				}
			}
			return true;
		}
		return false;
	}
	
	private static void setNewDirections() {
		do {
			for(int i = 0; i < 3; i++) {
				switch(RandomGenerator.randomInteger(0, 3)) {
				case 0:
					direction[i] = Location.WALL;
					break;

				case 1:
					direction[i] = Location.CORRIDOR;
					break;

				case 2:
					direction[i] = Location.DOOR;
					break;

				case 3:
					direction[i] = Location.CHEST;
					break;

				default:
					break;
				}
			}
		} while(direction[0] != Location.WALL|| direction[1] != Location.WALL|| direction[2] != Location.WALL);
	}
	
	private static Boolean encounterCalc(Location location) {
		if(RandomGenerator.randomInteger(0, 100) <= location.getChanche()) {
			Encounter.encounter(location, player);
			return true;
		}
		else{
			
			return false;
		}
	}
}