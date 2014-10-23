package dc.character;

import java.util.EnumSet;
import java.util.HashMap;

import dc.item.ItemCategory;
import dc.item.ItemTyp;

enum RaceBag {

	MERCENARY(Race.MERCENARY, true, 6, 5, EnumSet.of(ItemCategory.NORMAL), EnumSet.of(ItemTyp.SWORD, ItemTyp.BOW));
	
	private Race owner;
	private Boolean hasName;
	private Integer maxBagSlots;
	private Integer unitCost;
	private EnumSet<ItemCategory> usableCategorys;
	private EnumSet<ItemTyp> usableTyps;
	
	private RaceBag(Race owner, Boolean hasName, Integer maxBagSlots, Integer unitCost, EnumSet<ItemCategory> usableCategorys, EnumSet<ItemTyp> usableTyps) {
		this.owner = owner;
		this.hasName = hasName;
		this.maxBagSlots = maxBagSlots;
		this.unitCost = unitCost;
		this.usableCategorys = usableCategorys;
		this.usableTyps = usableTyps;
	}

	public static RaceBag getRace(Race race) {
		for(RaceBag testRace: RaceBag.values()) {
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
		helpMap.put(SuffixVariable.MAXBAGSLOTS, maxBagSlots);
		helpMap.put(SuffixVariable.UNITCOST, unitCost);
		helpMap.put(SuffixVariable.USABLECATEGORYS, usableCategorys);
		helpMap.put(SuffixVariable.USABLETYPS, usableTyps);
		return helpMap;
	}
}