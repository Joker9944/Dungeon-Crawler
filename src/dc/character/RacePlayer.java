package dc.character;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;

import dc.item.Item;
import dc.item.ItemCategory;
import dc.item.ItemTyp;

enum RacePlayer {
	HUMAN(Race.HUMAN, 6, EnumSet.of(ItemCategory.NORMAL), EnumSet.of(ItemTyp.SWORD, ItemTyp.DAGGER, ItemTyp.BOW),
			new HashSet<Item>(Arrays.asList(new Item("Ironsword", ItemCategory.LIGHT, ItemTyp.SWORD, 1D), new Item("Leatherchestplate", ItemCategory.LIGHT, ItemTyp.CHESTPLATE, 1D)))),
	ELF(Race.ELF, 6, EnumSet.of(ItemCategory.LIGHT), EnumSet.of(ItemTyp.DAGGER, ItemTyp.BOW),
			new HashSet<Item>(Arrays.asList(new Item("Irondagger", ItemCategory.LIGHT, ItemTyp.DAGGER, 0.5), new Item("Leatherchestplate", ItemCategory.LIGHT, ItemTyp.CHESTPLATE, 1D)))),
	ORK(Race.ORK, 6, EnumSet.of(ItemCategory.HEAVY), EnumSet.of(ItemTyp.SWORD, ItemTyp.AXE, ItemTyp.BOW),
			new HashSet<Item>(Arrays.asList(new Item("Ironsword", ItemCategory.LIGHT, ItemTyp.SWORD, 1D), new Item("Leatherchestplate", ItemCategory.LIGHT, ItemTyp.CHESTPLATE, 1D)))),
	DWARF(Race.DWARF, 6, EnumSet.of(ItemCategory.HEAVY), EnumSet.of(ItemTyp.SWORD, ItemTyp.AXE),
			new HashSet<Item>(Arrays.asList(new Item("Ironsword", ItemCategory.LIGHT, ItemTyp.SWORD, 1D), new Item("Leatherchestplate", ItemCategory.LIGHT, ItemTyp.CHESTPLATE, 1D))));
	
	private Race owner;
	private Integer maxBagSlots;
	private EnumSet<ItemCategory> usableCategorys;
	private EnumSet<ItemTyp> usableTyps;
	private HashSet<Item> startItems;
	
	private RacePlayer(Race owner, Integer maxBagSlots, EnumSet<ItemCategory> usableCategorys, EnumSet<ItemTyp> usableTyps, HashSet<Item> startItems) {
		this.owner = owner;
		this.maxBagSlots = maxBagSlots;
		this.usableCategorys = usableCategorys;
		this.usableTyps = usableTyps;
		this.startItems = startItems;
	}
	
	public static RacePlayer getRace(Race race) {
		for(RacePlayer testRace: RacePlayer.values()) {
			if(race.equals(testRace.getOwner())) {
				return testRace;
			}
		}
		return null;
	}

	public Race getOwner() {
		return owner;
	}
	
	public HashMap<SuffixVariable, Object> getValues() {
		HashMap<SuffixVariable, Object> helpMap = new HashMap<SuffixVariable, Object>();
		helpMap.put(SuffixVariable.OWNER, owner);
		helpMap.put(SuffixVariable.MAXBAGSLOTS, maxBagSlots);
		helpMap.put(SuffixVariable.USABLECATEGORYS, usableCategorys);
		helpMap.put(SuffixVariable.USABLETYPS, usableTyps);
		helpMap.put(SuffixVariable.STARTITEMS, startItems);
		return helpMap;
	}
}