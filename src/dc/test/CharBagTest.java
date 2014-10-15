package dc.test;

import org.junit.Test;

import dc.character.CharBag;
import dc.character.Race;
import dc.item.Item;
import dc.item.ItemCategory;
import dc.item.ItemTyp;

public class CharBagTest {

	CharBag test;
	
	@Test
	public void removeItemTest() {
		test = new CharBag("test_char", Race.HUMAN);
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
		test = new CharBag("test_char", Race.HUMAN);
		System.out.println("showBag method test" + '\n');
		System.out.println("Expected Error");
		test.showBag();
		System.out.println('\n');
	}
	
	@Test
	public void addItemsTest() {
		test = new CharBag("test_char", Race.HUMAN);
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
}
