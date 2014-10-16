package dc.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dc.character.Char;
import dc.character.CharBag;
import dc.character.CharInventory;
import dc.character.InventorySlot;
import dc.character.Race;
import dc.character.RaceSuffix;
import dc.item.Item;
import dc.item.ItemCategory;
import dc.item.ItemTyp;
import dc.utils.*;

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
				}
			}
			if(input.matches("^help.*")) {
				Text.helpCreat(input);
			}
		}
		player.setHP(player.getMaxHP());
		player.setMP(player.getMaxMP());
		System.out.println("Chracter created");
		while (player.getHP() > 0) {
			input = ConsoleReader.readString("Select");
			// Move
			if(input.matches("^move.*|^move")) {
				if(input.matches("^move")) {
					System.out.println("Enter Direction or objekt where you want to move to.");
				}
				if(input.matches(".*wall?")) {
					System.out.println("You can't go that way.");
					
				}
				for(Location dire: Location.values()) {
					if(input.matches(".*" + dire.getName())) {
						encounterCalc(dire.getChanche(), dire);
						setNewDirections();
					}
				}
				/*if(input.matches(".*corridor?")) {
					combat.encounter(5, false, "corridor", player);
					setNewDirections();
				}
				if(input.matches(".*door?")) {
					combat.encounter(50, false, "door", player);
					setNewDirections();
				}
				if(input.matches(".*chest?")) {
					combat.encounter(30, false, "chest", player);
					setNewDirections();
				}*/
			}
			// Bag / Inventory
			if(input.matches("^bag.*|^bag")) {
				if(input.matches(".*show?|^bag")) {
					player.showBag();
				}
				if(input.matches(".*drop.*")) {
					player.removeItem(input);
					System.out.println(input);
				}
				if(input.matches(".*equip.*")) {
					player.equipItemFromBag(input);
					System.out.println(input);
				}
				if(input.matches(".*unequip.*")) {
					player.unequipItem(input);
					System.out.println(input);
				}
			}
			// Rest
			if(input.matches("^rest")) {
				if(RandomGenerator.randomInteger(0, 100) <= 30) {
					encounterCalc(100, "Rest");
				}
				else {
					int t;
					int m;
					t = ((player.getMaxHP() - player.getHP()) / 3);
					m = ((player.getMaxMP() - player.getMP()) / 5);
					player.setHP(player.getHP() + t);
					player.setMP(player.getMP() + t);
					System.out.println("You have restet and restort " + t + " TP and "
							+ m + " MP.");
				}
			}
			// Search
			if(input.matches("^search")) {
				Integer i = RandomGenerator.randomInteger(0, 100);
				if(i >= 0 && i <= 80) {
					//Text.move(direction);
				}
				if(i >= 81 && i <= 95) {
					//TODOcombat.encounter(0, true, "Search", player);
				}
				if(i >= 96 && i <= 100) {
					// loot
				}
			}
			// Status
			if(input.matches("^status")) {
				System.out.println(player.getName());
				System.out.println(player.getRace().getRace());
				System.out.println("HP: " + player.getHP());
				if(player.getClm()==true) {
					System.out.println("MP: " + player.getMP());
				}
				System.out.println('\n' + "Equipment:" + '\n');
				InventorySlot ausgabe[] = new InventorySlot[] {InventorySlot.WEAPON, InventorySlot.HEAD, InventorySlot.CHEST, InventorySlot.HANDS, InventorySlot.LEGS};
				Item helpItem;
				for(Integer i = 0; i < 5; i++) {
					helpItem = player.getEquipedItem(ausgabe[i]);
					if(helpItem != null) {
						System.out.println(helpItem.getName() + '\n' + "Value: " + helpItem.getValue());
					}
				}
			}
			// help
			if(input.matches("^help.*|^help")) {
				Text.helpMenu(input);
			}
		}
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
	
	private static Boolean encounterCalc(Integer chanche, Location location) {
		if(RandomGenerator.randomInteger(0, 100) <= chanche) {
			Encounter.encounter(location, player);
			return true;
		}
		else{
			
			return false;
		}
	}

	public static CharInventory getPlayer() {
		return player;
	}
}