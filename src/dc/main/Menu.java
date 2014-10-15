package dc.main;

import java.util.ArrayList;

import dc.utils.*;

public class Menu {

	private static String direction[] = new String[] {"Corridor", "Corridor", "Corridor"};
	private static Char player;
	private static ArrayList<Char> enemy = new ArrayList<>();
	
	static Combat combat = new Combat();
	
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
			if(input.matches("human")) {
				player = new Char(name, Race.HUMAN);
				player.equipItem(new Item(new String("Ironsword"), ItemCategory.NORMAL, ItemTyp.SWORD, new Double(4)));
				player.equipItem(new Item(new String("Leather Chestplate"), ItemCategory.NORMAL, ItemTyp.CHESTPLATE, new Double(4)));
				player.equipItem(new Item(new String("Leather Pants"), ItemCategory.NORMAL, ItemTyp.LEGINS, new Double(4)));
				player.addItem(new Item(new String("Leather Pants"), ItemCategory.NORMAL, ItemTyp.LEGINS, new Double(4)));
			}
			if(input.matches("elf")) {
				player = new Char(name, Race.ELF);
			}
			if(input.matches("ork")) {
				player = new Char(name, Race.ORK);
			}
			if(input.matches("dwarf")) {
				player = new Char(name, Race.DWARF);
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
				if(input.matches(".*corridor?")) {
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
				}
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
					player.equipItem(input);
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
					combat.encounter(0, true, "Rest", player);
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
					Text.move(direction);
				}
				if(i >= 81 && i <= 95) {
					combat.encounter(0, true, "Search", player);
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
					direction[i] = "Wall";
					break;

				case 1:
					direction[i] = "Corridor";
					break;

				case 2:
					direction[i] = "Door";
					break;

				case 3:
					direction[i] = "Chest";
					break;

				default:
					break;
				}
			}
		} while(direction[0] != "Wall" || direction[1] != "Wall"|| direction[2] != "Wall");
	}

	public static Char getPlayer() {
		return player;
	}

	public static ArrayList<Char> getEnemy() {
		return enemy;
	}
}