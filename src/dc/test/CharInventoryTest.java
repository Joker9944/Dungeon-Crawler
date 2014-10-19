package dc.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import dc.character.CharInventory;
import dc.character.Race;
import dc.item.Item;
import dc.item.ItemCategory;
import dc.item.ItemTyp;

public class CharInventoryTest {

	CharInventory test;
	
	@Test
	public void equipItemTest() {
		test = (CharInventory) Race.getNewChar("test_char", Race.HUMAN);
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
	public void removeItemInventroyTest() {
		test = (CharInventory) Race.getNewChar("test_char", Race.HUMAN);
		System.out.println("removeItemInventroy method test (2 methods)" + '\n');
		
		System.out.println("removeItemInventroy(Item) test" + '\n');
		System.out.println("No error expected");
		test.equipItem(new Item("test_sword", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		test.removeItemInventroy(test.getEquipedItem(CharInventory.InventorySlot.WEAPON).get());
		System.out.println("Error expected");
		test.removeItemInventroy(new Item("no_item", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		System.out.println('\n');
		
		System.out.println("removeItemInventroy(CharInventory.InventorySlot) test" + '\n');
		System.out.println("No error expected");
		test.equipItem(new Item("test_sword", ItemCategory.NORMAL, ItemTyp.SWORD, 2D));
		test.removeItemInventroy(CharInventory.InventorySlot.WEAPON);
		System.out.println("Error expected");
		test.removeItemInventroy(CharInventory.InventorySlot.WEAPON);
		System.out.println('\n');
	}
}