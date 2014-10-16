package dc.main;

import java.util.ArrayList;

import dc.character.Char;
import dc.character.Race;
import dc.utils.*;

abstract class Encounter {

	public static void encounter(Location location, Char player) {
		String input;
		Boolean turn;
		// true=Player
		// false=Creeps
		ArrayList<Char> enemy;
		// Initiative
		turn = initiative(location);
		// Init enemy
		enemy = enemy(location, player);
		// Text encounter
		//TODO Text.java
		/*while (player.getHP() > 0 && creep.getHP() > 0) {
			if (turn == true) {
				while (turn == true) {
					input = ConsoleReader.readString("What will you do?");
					if (input.matches("^attack.*") == true) {
						if (input.matches("^attack")) {
							System.out.println("Select a target.");
						} else {
							attack(player, input, creep);
						}
						turn = false;
					}
					if (input.matches("^spell.*") == true) {
						// spells
					}
					if (input.matches("^bag.*") == true) {
						// bag
					}
					if (input.matches("status") == true) {
						// player info

						// creep info
						System.out.println(creep.getRace());
						if (creep.getRace().getRace() == creep.getName()) {
							System.out.println(creep.getName());
						}
						System.out.print('\n');
					}
					if (input.matches("flee") == true) {
						Text.helpCreat(input);
					}
					turn = false;
				}
			} else {

			}
		}*/
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
	
	private static ArrayList<Char> enemy(Location location, Char player) {
		ArrayList<Char> enemys = new ArrayList<Char>();
		
		
		
		return enemys;
	}

	private void attack(Char attacker, String target, Char creep) {
		if (target.matches(".*" + creep.getName() + "?")) {
			attack(attacker, creep);
		} else {
			System.out.println("Invalid target");
		}
	}

	private static void attack(Char attacker, Char target) {

	}
}
