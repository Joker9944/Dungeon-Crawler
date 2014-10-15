package dc.test;

import org.junit.Test;

import static org.junit.Assert.*;
import dc.character.CharInventory;
import dc.character.InventorySlot;
import dc.character.Race;
import dc.item.Item;
import dc.item.ItemCategory;
import dc.item.ItemTyp;

public class CharInventoryTest {

	CharInventory test;
	
	@Test
	public void equipItemFromBagTest() {
		test = new CharInventory("test_char", Race.HUMAN);
		System.out.println("equipItemFromBag method test" + '\n');
		
		test.addItem(new Item("test_sword", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		System.out.println("No error expected");
		if(!test.equipItemFromBag("test_sword")) {
			fail("false was not expected");
		}
		System.out.println(test.getEquipedItem(InventorySlot.WEAPON).getName());
		System.out.println("Pass!");
		System.out.println("Error expected");
		if(test.equipItemFromBag("no_item")) {
			fail("true was not expected");
		}
		System.out.println("Pass!");
		
		System.out.println('\n');
	}
	
	@Test
	public void equipItemTest() {
		test = new CharInventory("test_char", Race.HUMAN);
		System.out.println("equipItem method test" + '\n');
		
		System.out.println("No error expected");
		if(!test.equipItem(new Item("test_sword", ItemCategory.NORMAL, ItemTyp.SWORD, 2D))) {
			fail("false was not expected");
		}
		System.out.println("Pass!");
		System.out.println("Error expected");
		if(test.equipItem(new Item("test_sword", ItemCategory.NORMAL, ItemTyp.SWORD, 2D))) {
			fail("true was not expected");
		}
		System.out.println("Pass!");
		
		System.out.println('\n');
	}
	
	@Test
	public void unequipItemTest() {
		test = new CharInventory("test_char", Race.HUMAN);
		System.out.println("unequipItem method test (3 methods)" + '\n');
		
		System.out.println("unequipItem(Item) test" + '\n');
		System.out.println("No error expected");
		test.equipItem(new Item("test_sword", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		test.unequipItem(test.getEquipedItem(InventorySlot.WEAPON));
		System.out.println("Error expected");
		test.unequipItem(new Item("no_item", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		test.showBag();
		System.out.println('\n');
		
		System.out.println("unequipItem(InventorySlot) test" + '\n');
		System.out.println("No error expected");
		test.equipItem(new Item("test_sword", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		test.unequipItem(InventorySlot.WEAPON);
		System.out.println("Error expected");
		test.unequipItem(InventorySlot.WEAPON);
		test.showBag();
		System.out.println('\n');
		
		System.out.println("unequipItem(String) test" + '\n');
		System.out.println("Test String Itemname");
		System.out.println("No error expected");
		test.equipItem(new Item("test_sword", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		test.unequipItem("test_sword");
		System.out.println("Error expected");
		test.unequipItem("test_sword");
		System.out.println("Test String Slotname");
		System.out.println("No error expected");
		test.equipItem(new Item("test_sword", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		test.unequipItem("weapon");
		System.out.println("Error expected");
		test.unequipItem("weapon");
		test.showBag();
		System.out.println('\n');
	}
	
	@Test
	public void removeItemInventroyTest() {
		test = new CharInventory("test_char", Race.HUMAN);
		System.out.println("removeItemInventroy method test (2 methods)" + '\n');
		
		System.out.println("removeItemInventroy(Item) test" + '\n');
		System.out.println("No error expected");
		test.equipItem(new Item("test_sword", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		test.removeItemInventroy(test.getEquipedItem(InventorySlot.WEAPON));
		System.out.println("Error expected");
		test.removeItemInventroy(new Item("no_item", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		System.out.println("Error expected");
		test.showBag();
		System.out.println('\n');
		
		System.out.println("removeItemInventroy(InventorySlot) test" + '\n');
		System.out.println("No error expected");
		test.equipItem(new Item("test_sword", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		test.removeItemInventroy(InventorySlot.WEAPON);
		System.out.println("Error expected");
		test.removeItemInventroy(InventorySlot.WEAPON);
		System.out.println("Error expected");
		test.showBag();
		System.out.println('\n');
	}
}