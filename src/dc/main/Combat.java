package dc.main;

import dc.character.Char;
import dc.character.Race;
import dc.utils.*;

public class Combat {
	
	public void encounter(Integer chanche,Boolean force,String location,Char player) {
		if(RandomGenerator.randomInteger(0,100)<=chanche||force==true) {
			Boolean turn;
				//true=Player
				//false=Creeps
			String input;
			//text encounter
			
			
			
			//init creeps
			Char creep = new Char(Race.ORK);
			
			
			//initiative
			
			turn= new Boolean(true);
			
			
			while(player.getHP()>0&&creep.getHP()>0) {
				if(turn == true) {
					while(turn == true) {
						input=ConsoleReader.readString("What will you do?");
						if(input.matches("^attack.*") == true) {
							if(input.matches("^attack")) {
								System.out.println("Select a target.");
							}
							else {
								attack(player, input, creep);
							}
							turn = false;
						}
						if(input.matches("^spell.*") == true) {
							//spells
						}
						if(input.matches("^bag.*") == true) {
							//bag
						}
						if(input.matches("status") == true) {
							//player info
							
							//creep info
							System.out.println(creep.getRace());
							if(creep.getRace().getRace()==creep.getName()) {
								System.out.println(creep.getName());
							}
							System.out.print('\n');
						}
						if(input.matches("flee") == true) {
							Text.helpCreat(input);
						}
					turn=false;
					}
				}
				else {
					
				}
			}
		}
	}
	private void attack(Char attacker, String target, Char creep) {
		if(target.matches(".*" + creep.getName() + "?")) {
			attack(attacker, creep);
		}
		else {
			System.out.println("Invalid target");
		}
	}
	
	private void attack(Char attacker, Char target) {
		
	}
}
