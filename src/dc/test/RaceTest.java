package dc.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import dc.character.Char;
import dc.character.CharBag;
import dc.character.CharInventory;
import dc.character.Race;

public class RaceTest {

	@SuppressWarnings("unused")
	@Test
	public void getNewCharTest() {
		System.out.println("getNewCharTest" + '\n');
		try {
			CharBag test1 = (CharBag) Race.getNewChar("test_char", Race.HUMAN); // Preffix Player cast to CharBag
			System.out.println("Cast from Char to Charbag succses");
		}
		catch(ClassCastException e) {
			fail("Possible cast Char to CharBag failed");
		}
		try {
			CharInventory test2 = (CharInventory) Race.getNewChar("test_char", Race.SPIDER); // Preffix Blank no Cast possible
			fail("Inpossible cast succses");
		}
		catch(ClassCastException e) {
			System.out.println("Not possible cast fail (Good)" + '\n' + e.getMessage());
		}
		try {
			CharInventory test3 = (CharInventory) Race.getNewChar("test_char", Race.GOBLIN); // Prefiix Inventory cast to CharInventory
			System.out.println("Cast from Char to CharInventory succses");
		}
		catch(ClassCastException e) {
			fail("Possible cast Char to CharInventory failed");
		}
		CharBag test4 = (CharBag) Race.getNewChar("test_char", Race.MERCENARY);
		System.out.println('\n');
	}

	@Test
	public void getMaxBagSlotsTest() {
		System.out.println("getMaxBagSlotsTest" + '\n');
		CharBag test1 = (CharBag) Race.getNewChar("test_char", Race.HUMAN);
		Char test2 = Race.getNewChar("test_char", Race.SPIDER);
		try {
			System.out.println("Try to get max slots from Char with slot");
			System.out.println("Max slots: " + test1.getRace().getMaxBagSlots());
		}
		catch (Exception e) {
			fail(e.getMessage());
		}
		try {
			System.out.println("Try to get max slots from Char without slot");
			System.out.println("Max slots: " + test2.getRace().getMaxBagSlots());
			fail("Got slots from Char without slots");
		}
		catch (Exception e) {
			System.out.println("Did not get slots(Good)");
		}
		System.out.println('\n');
	}
	
	@Test
	public void getUnitCostTest() {
		System.out.println("getUnitCostTest" + '\n');
		System.out.println("Init Chars / no Errors expected");
		Char test1 = Race.getNewChar("test_char", Race.SPIDER);
		CharInventory test2 = (CharInventory) Race.getNewChar("test_char", Race.GOBLIN);
		CharBag test3 = (CharBag) Race.getNewChar("test_char", Race.MERCENARY);
		CharBag test4 = (CharBag) Race.getNewChar("test_char", Race.HUMAN);
		System.out.println("Get UnitCost from BLANC");
		try {
			System.out.println("Unitcost: " + test1.getRace().getUnitCost());
			System.out.println("Succses");
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
		System.out.println("Get UnitCost from INVENTORY");
		try {
			System.out.println("Unitcost: " + test2.getRace().getUnitCost());
			System.out.println("Succses");
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
		System.out.println("Get UnitCost from BAG");
		try {
			System.out.println("Unitcost: " + test3.getRace().getUnitCost());
			System.out.println("Succses");
		}
		catch(Exception e) {
			fail(e.getMessage());
		}
		System.out.println("Get UnitCost from PLAYER");
		try {
			System.out.println("Unitcost: " + test4.getRace().getUnitCost());
			fail("Got not null");
			
		}
		catch(Exception e) {
			System.out.println("Succses");
		}
		System.out.println('\n');
	}
}
