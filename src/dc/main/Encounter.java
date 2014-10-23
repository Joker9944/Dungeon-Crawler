package dc.main;

import java.util.ArrayList;
import java.util.Optional;

import dc.character.CharBag;
import dc.character.CharBlank;
import dc.character.CharInventory;
import dc.character.Race;
import dc.item.Item;
import dc.utils.ConsoleReader;
import dc.utils.RandomGenerator;

public abstract class Encounter {

	private static String input;
	private static Boolean turn;
					// true=Player
					// false=Creeps
	private static ArrayList<CharBlank> enemyList;
	
	public static void encounter(Location location, CharBag player) {
		System.out.println("Encounter");
		// Initiative
		turn = initiative(location);
		// Init enemy
		enemyList = generateEnemys();
		// Text encounter
		//TODO Text.java
		do {
			if (turn.equals(true)) {
				input = ConsoleReader.readString("What will you do? ");
				if (input.matches("^attack.*")) {
					// Attack
					if(input.matches("^attack")) {
						System.out.println("Select a target.");
					} else {
						if(attack(player, input)) {
							turn = false;
						}
					}
					// Bag
					Menu.bag(input);
					// Status
					if(Menu.status(input)){statusExtension();}
					// TODO Flee
				}
			} else {
				for(CharBlank enemy: enemyList) {
					//TODO AI
					attack(player, enemy);
					
				}
				turn = false;
			}
			for(CharBlank enemy: enemyList) {
				if(enemy.getHP() <= 0) {
					enemyList.remove(enemy);
				}
			}
		} while(player.getHP() > 0 && !enemyList.isEmpty());
	}

	private static Boolean initiative(Location location) {
		if(RandomGenerator.randomInteger(0, 100) > location.getInitiative()) {
			// Player initiative
			return true;
		}
		else{
			// Enemy initative
			return false;
		}
	}
	
	private static ArrayList<CharBlank> generateEnemys() {
		ArrayList<CharBlank> enemyList = new ArrayList<CharBlank>();
		ArrayList<Race> raceList = new ArrayList<Race>();
		Integer unitResource = 10;
		for(Race race: Race.values()) {
			if(!race.isPlayerRace()) {
				raceList.add(race);
			}
		}
		while((!raceList.isEmpty() && unitResource > 0)) {
			Race race = raceList.get(RandomGenerator.randomInteger(0, raceList.size() - 1));
			if(unitResource - race.getUnitCost() > 0) {
				if(race.getHasName()) {
					//TODO EnemyNameList
					enemyList.add(Race.getNewChar("test_name", race));
				} else {
					Integer count = 0;
					if(!enemyList.isEmpty()) {
						for(CharBlank enemy: enemyList){
							if(enemy.getName().matches("(?i)" + race.getRace() + ".*")) {
								count++;
							}
						}
					}
					enemyList.add(Race.getNewChar(race.getRace() + " (" + (count + 1) + ")", race));
				}
				unitResource = unitResource - race.getUnitCost();
			} else {
				raceList.remove(race);
			}
		}
		return enemyList;
	}
	
	public static void statusExtension() {
		System.out.println('\n' + "Enemys:");
		for(CharBlank enemy: enemyList) {
			System.out.println(enemy.getName());
		}
	}
	
	private static Boolean attack(CharBlank attacker, String target) {
		for(CharBlank enemy: enemyList) {
			if(target.matches("(?i).*" + enemy.getName() + "?")) {
				attack(attacker, enemy);
				return true;
			}
		}
		return false;
	}

	private static void attack(CharBlank attacker, CharBlank target) {
		Double damage;
		Double armor;
		if(attacker.getClass().equals(CharBlank.class)) {
			damage = attacker.getRace().getDamage();
		} else {
			Optional<Item> helpContainer = ((CharInventory) attacker).getEquipedItem(CharInventory.InventorySlot.WEAPON);
			if(helpContainer.isPresent()) {
				damage = helpContainer.get().getValue();
			} else {
				damage = 0D;
			}
		}
		if(target.getClass().equals(CharBlank.class)) {
			armor = target.getRace().getArmor();
		} else {
			armor = ((CharInventory) target).getArmor();
		}
		target.setHP(target.getHP() - DamageCalc(damage, armor));
	}
	
	private static Double DamageCalc(Double damage, Double armor) {
		//TODO Better system / balanching
		return damage / armor;
	}
}