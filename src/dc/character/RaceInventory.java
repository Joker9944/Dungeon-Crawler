package dc.character;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

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
		this.unitCost = unitCost;
		this.usableCategorys = usableCategorys;
		this.usableTyps = usableTyps;
	}

	public Race getOwner() {
		return owner;
	}
	
	public Boolean getHasName() {
		return hasName;
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