package dc.character;

import java.util.EnumSet;
import java.util.HashMap;

import dc.item.ItemCategory;
import dc.item.ItemTyp;

enum RaceInventory {

	//TODO Loottable
	
	GOBLIN(Race.GOBLIN, false, 3, EnumSet.of(ItemCategory.NORMAL), EnumSet.of(ItemTyp.SWORD, ItemTyp.DAGGER, ItemTyp.BOW));
	
	private Race owner;
	private Boolean hasName;
	private Integer unitCost;
	private EnumSet<ItemCategory> usableCategorys;
	private EnumSet<ItemTyp> usableTyps;
	
	private RaceInventory(Race owner, Boolean hasName, Integer unitCost, EnumSet<ItemCategory> usableCategorys, EnumSet<ItemTyp> usableTyps) {
		this.owner = owner;
		this.hasName = hasName;
		this.unitCost = unitCost;
		this.usableCategorys = usableCategorys;
		this.usableTyps = usableTyps;
	}

	public static RaceInventory getRace(Race race) {
		for(RaceInventory testRace: RaceInventory.values()) {
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
		helpMap.put(SuffixVariable.HASNAME, hasName);
		helpMap.put(SuffixVariable.UNITCOST, unitCost);
		helpMap.put(SuffixVariable.USABLECATEGORYS, usableCategorys);
		helpMap.put(SuffixVariable.USABLETYPS, usableTyps);
		return helpMap;
	}
}