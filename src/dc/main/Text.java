package dc.main;

public abstract class Text {

	public static void move(Location[] location) {
		System.out.println(location[0].getName() + '\n' + location[1].getName() + '\n' + location[2].getName());
	}
	
	public static void helpMenu(String input) {
		if(input.matches("^help")==true) {
			System.out.println("move" + '\t' + "bag" + '\t' + "rest" + '\t' + "search");
		}
		else {
			if(input.matches(".*move?")==true) {
				System.out.println("Enter Direction or objekt where you want to move to.");
			}
			if(input.matches(".*bag?")==true) {
				System.out.println("Show your Inventory");
			}
			if(input.matches(".*rest?")==true) {
				System.out.println("Get some rest and restore some HP and MP.");
			}
			if(input.matches(".*search?")==true) {
				System.out.println("Search your souroundings.");
			}
		}
	}
	
	public static void helpCreat(String input) {
		if(input.matches("^help")==true) {
			System.out.println("human"+'\t'+"elf"+'\t'+"ork"+'\t'+"dwarf");
		}
		else {
			if(input.matches(".*human?")==true) {
				System.out.println("Human" + '\n' + "HP: 100" + '\n' + "MP: 100");
				System.out.println("(Info text in progress.)");
			}
			if(input.matches(".*elf?")==true) {
				System.out.println("Elf" + '\n' + "HP: 50" + '\n' + "MP: 150");
				System.out.println("(Info text in progress.)");
			}
			if(input.matches(".*ork?")==true) {
				System.out.println("Ork" + '\n' + "HP: 150" + '\n' + "MP: 50");
				System.out.println("(Info text in progress.)");
			}
			if(input.matches(".*dwarf?")==true) {
				System.out.println("Dwarf" + '\n' + "HP: 200");
				System.out.println("(Info text in progress.)");
			}
		}
	}
	
	public static void helpCombat() {
		System.out.println("attack" + '\t' + "spell book" + '\t' + "open bag" + '\t' +"flee");
	}
	
	public void door(Integer material,Integer sound) {
		
		/*System.out.print("You examine the door: The door is made out of ");
		switch (random.number(1,2)) {
			case 1:
				System.out.print("wood. ");
				break;
			case 2:
				System.out.print("metal. ");
				break;
			default:
				break;
		}
		switch (random.number(1,2)) {
		case 1:
			System.out.println("You listen carefully and you hear nothing.");
			break;
		case 2:
			System.out.println("You listen carefully and you hear something.");
			break;
		default:
			break;
		}
		break;*/
	}
	
	public void chest() {
		
	}
}
