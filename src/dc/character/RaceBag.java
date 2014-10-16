package dc.character;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import dc.item.ItemCategory;
import dc.item.ItemTyp;

enum RaceBag {

	// Player
	HUMAN(Race.HUMAN, 6, EnumSet.of(ItemCategory.NORMAL), EnumSet.of(ItemTyp.SWORD, ItemTyp.DAGGER, ItemTyp.BOW)),
	ELF(Race.ELF, 6, EnumSet.of(ItemCategory.LIGHT), EnumSet.of(ItemTyp.DAGGER, ItemTyp.BOW)),
	ORK(Race.ORK, 6, EnumSet.of(ItemCategory.HEAVY), EnumSet.of(ItemTyp.SWORD, ItemTyp.AXE, ItemTyp.BOW)),
	DWARF(Race.DWARF, 6, EnumSet.of(ItemCategory.HEAVY), EnumSet.of(ItemTyp.SWORD, ItemTyp.AXE)),
	// Enemy
	MERCENARY(Race.MERCENARY, 6, EnumSet.of(ItemCategory.NORMAL), EnumSet.of(ItemTyp.SWORD, ItemTyp.BOW));
	
	private Race owner;
	private Integer maxBagSlots;
	private EnumSet<ItemCategory> usableCategorys;
	private EnumSet<ItemTyp> usableTyps;
	
	private RaceBag(Race owner, Integer maxBagSlots, EnumSet<ItemCategory> usableCategorys, EnumSet<ItemTyp> usableTyps) {
		this.owner = owner;
		this.maxBagSlots = maxBagSlots;
		this.usableCategorys = usableCategorys;
		this.usableTyps = usableTyps;
	}

	public Race getOwner() {
		return owner;
	}

	public Integer getMaxBagSlots() {
		return maxBagSlots;
	}

	@Deprecated
	public EnumSet<ItemCategory> getUsableCategorys() {
		return usableCategorys;
	}

	@Deprecated
	public EnumSet<ItemTyp> getUsableTyps() {
		return usableTyps;
	}
	
	public ArrayList<Object> getUsableItems() {
		List<Object> helpList = new ArrayList<Object>();
		helpList.add(usableCategorys);
		helpList.add(usableTyps);
		return (ArrayList<Object>) helpList;
	}
}