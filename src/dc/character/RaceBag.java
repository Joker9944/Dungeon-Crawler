package dc.character;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

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
		this.maxBagSlots = maxBagSlots;
		this.usableCategorys = usableCategorys;
		this.usableTyps = usableTyps;
	}

	public Race getOwner() {
		return owner;
	}
	
	public Boolean getHasName() {
		return hasName;
	}

	public Integer getMaxBagSlots() {
		return maxBagSlots;
	}
	
	public Integer getUnitCost() {
		return unitCost;
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