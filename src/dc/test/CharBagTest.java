package dc.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import dc.character.CharBag;
import dc.character.InventorySlot;
import dc.character.Race;
import dc.item.Item;
import dc.item.ItemCategory;
import dc.item.ItemTyp;

public class CharBagTest {

	CharBag test;
	
	@Test
	public void removeItemTest() {
		test = (CharBag) Race.getNewChar("test_char", Race.HUMAN);
		System.out.println("removeItem method test (2 methods)" + '\n');
		System.out.println("removeItem(String) test");
		test.addItem(new Item("test_sword", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		test.removeItem("test_sword");
		System.out.println("Bag should be empty");
		test.showBag();
		System.out.println("removeItem(Item) test");
		test.addItem(new Item("test_sword", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		test.removeItem(test.getBag().get(0));
		System.out.println('\n');
	}
	
	@Test
	public void showBagTest() {
		test = (CharBag) Race.getNewChar("test_char", Race.HUMAN);
		System.out.println("showBag method test" + '\n');
		System.out.println("Expected Error");
		test.showBag();
		System.out.println('\n');
	}
	
	@Test
	public void addItemsTest() {
		test = (CharBag) Race.getNewChar("test_char", Race.HUMAN);
		System.out.println("addItem method test" + '\n');
		test.addItem(new Item("test_sword5", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		test.showBag();
		System.out.println('\n' + "Adding more items then aloud");
		for(int i = 0; i < test.getRace().getMaxBagSlots(); i++) {
			test.addItem(new Item("test_sword" + i, ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		}
		test.showBag();
		System.out.println('\n');
	}
	
	@Test
	public void equipItemFromBagTest() {
		test = (CharBag) Race.getNewChar("test_char", Race.HUMAN);
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
	public void unequipItemTest() {
		test = (CharBag) Race.getNewChar("test_char", Race.HUMAN);
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
}
